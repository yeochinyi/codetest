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

        open fun cellCallback(){}

        var value: T by Delegates.observable(input){
            _, old, new ->
            if(old != new){
                dependentSet.forEach{ it.cellCallback() }
                callbacks.forEach{ it.invoke(value) }
            }
        }
        
        fun registerDependent(cell:Cell){
            dependentSet.add(cell)
        }

        var callbacks = mutableListOf<((T)->Unit)>()

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
            inputs.forEach{it.registerDependent(this)}
            cellCallback()
        }

        override fun cellCallback() {            
            value = compute(inputs.map{it->it.value})
            // println("cellCallback value=${value}")
        }

    }
}

// fun main(args:Array<String>) {
//     val reactor = Reactor<Int>()
//     val input = reactor.InputCell(1)
//     val output = reactor.ComputeCell(input) { it[0] + 1 }
//     input.value = 3
//     print(output.value)
// }

