import kotlin.properties.Delegates

class Reactor<T>() {
    // Your compute cell's addCallback method must return an object
    // that implements the Subscription interface.
    interface Subscription {
        fun cancel()
    }

    inner class CellSubscription(): Subscription {
        override fun cancel() {
        }
    }

    inner abstract class Cell(input:T){
        var set = mutableSetOf<Cell>()

        var value: T by Delegates.observable(input){
            _, old, new ->            
            if(old != new){
                set.forEach{ it.cellCallback() }
                if(callback != null){
                    callback?.invoke(value)
                }
            }
            
        }
        
        fun register(cell:Cell){
            set.add(cell)
        }

        abstract fun cellCallback()

        var callback: ((T)->Unit)? = null

        fun addCallback(cb: (T)->Unit):Subscription {            
            this.callback = cb
            return CellSubscription()
        }


    }

    inner class InputCell(input:T):Cell(input){
        override fun cellCallback() {}
    }

    inner class ComputeCell(vararg val inputs: Cell, val compute:(List<T>) -> T):Cell(inputs[0].value){
        init{
            inputs.forEach{it.register(this)}
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

