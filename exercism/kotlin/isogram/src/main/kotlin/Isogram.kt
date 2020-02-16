object Isogram {

    // return true is input is isogram
    fun isIsogram(input: String): Boolean {
        return input.toLowerCase().toCharArray()
                .filter { "[a-z]".toRegex().matches("$it") }
                .let{ it.toSet().size == it.size}
    }

    // fun isIsogram(input: String) = input.filter(Char::isLetter).map(Char::toLowerCase).let {
    //     it.toSet().size == it.size
    // }
}
