object Pangram {

    // returns true if string is a pangram
    fun isPangram(input: String): Boolean {
        val regexFunc =  { c: Char -> "[a-z]".toRegex().matches( c.toString() ) }
        return input.toLowerCase().toCharArray().filter { regexFunc(it) }.toSet().size == 26

    //    return ('a'..'z').all { input.contains(it, ignoreCase = true) }

    }
}

fun main(args: Array<String>){
    Pangram.isPangram(args[0])
}
