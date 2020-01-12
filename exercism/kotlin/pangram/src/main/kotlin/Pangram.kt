object Pangram {

    // returns true if string is a pangram
    fun isPangram(input: String): Boolean {
        val regexFunc =  { c: Char -> Regex("[a-z]").matches( c.toString() ) }
        return input.toLowerCase().toCharArray().filter { regexFunc(it) }.toSet().size == 26
    }
}

fun main(args: Array<String>){
    Pangram.isPangram(args[0])
}
