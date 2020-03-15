import kotlin.properties.Delegates

class Reactor<T>() {
    // Your compute cell's addCallback method must return an object
    // that implements the Subscription interface.
    interface Subscription {
        fun cancel()
    }

    inner class CellSubscription(val cell: Cell,val cb: (T)->Unit): Subscription {
        override fun cancel() {
            cell.removeCallback(cb)
        }
    }

    inner abstract class Cell(input:T){
        var dependentSet = mutableSetOf<Cell>()
        var upstreamSet = mutableSetOf<Cell>()

        var dirty = false

        open fun cellCallback(){
            dirty = true
        }

        var callbacks = mutableListOf<((T)->Unit)>()

        // var value: T by Delegates.observable(input){
        var value: T
            get() = _value!!
            set(newValue){
                println("${this.javaClass.kotlin} newValue=${newValue}")
                if(newValue != _value){
                    dependentSet.forEach{ it.cellCallback() }
                    // println("${this.javaClass.kotlin} upstreamSet=${upstreamSet.map{it.dirty}}")
                    if(!upstreamSet.any{ it.dirty }){
                        // println("callbacks=${callbacks}")
                        callbacks.forEach{ it.invoke(newValue) }
                    }
                    dirty = false                
                }
                _value = newValue
            }
        var _value: T? = null

        init{
            this.value = input
        }
        
        fun registerDependent(cell:Cell){
            dependentSet.add(cell)
        }

        fun addCallback(cb: (T)->Unit):Subscription {
            callbacks.add(cb)
            return CellSubscription(this, cb)
        }

        fun removeCallback(cb: (T)->Unit) {
            callbacks.remove(cb)
        }
    }

    inner class InputCell(input:T):Cell(input)
    
    // TODO hack... need to set set least 1 value in superclass Cell...
    inner class ComputeCell(vararg val inputs: Cell, val compute:(List<T>) -> T):Cell(inputs[0].value){
        init{
            inputs.forEach{
                upstreamSet.add(it)
                it.registerDependent(this)
            }
            cellCallback()
        }        

        override fun cellCallback() {     
            super.cellCallback()       
            value = compute(inputs.map{it->it.value})
            // println("cellCallback value=${value}")
        }

    }
}

fun main(args:Array<String>) {
        // fun callbacksShouldOnlyBeCalledOnceEvenIfMultipleDependenciesChange() {

        val reactor = Reactor<Int>()
        val input = reactor.InputCell(1)
        val plusOne = reactor.ComputeCell(input) { it[0] + 1 }
        val minusOne1 = reactor.ComputeCell(input) { it[0] - 1 }
        val minusOne2 = reactor.ComputeCell(minusOne1) { it[0] - 1 }
        val output = reactor.ComputeCell(plusOne, minusOne2) { (x, y) -> x * y }

        val vals = mutableListOf<Int>()
        output.addCallback { vals.add(it) }

        input.value = 4
        // assertEquals(listOf(10), vals)

        println("vals=${vals}")

}

