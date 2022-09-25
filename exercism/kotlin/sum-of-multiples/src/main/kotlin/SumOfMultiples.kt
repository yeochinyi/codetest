object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int) =
        (1 until limit).fold(0) { acc, i -> 
            val a = (factors.find { it != 0 && i % it == 0 }?.let { i } ?: 0 )
            acc + a
        }
    
}
