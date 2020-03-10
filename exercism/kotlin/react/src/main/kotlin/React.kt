class Reactor<T>() {
    // Your compute cell's addCallback method must return an object
    // that implements the Subscription interface.
    interface Subscription {
        fun cancel()
    }

    //class Cell<T>(var value:T)

    fun InputCell(input:T):Cell<T>{
        return input
    }

    fun ComputeCell(input:T):Cell<T>{
        // return Cell(input)
        
    }

    // fun ComputeCell(T input, fun compute()):Cell<T>{
    //     return 
    // }

}

// val reactor = Reactor<Int>()
// val input = reactor.InputCell(10)
// assertEquals(10, input.value)
