object Bob {

    // https://discuss.kotlinlang.org/t/using-regex-in-a-when/1794/6
    fun Regex.capture(string: String): List<String>? = find(string)?.destructured?.toList()

    fun <R> regexWhen(string: String, block: RegexWhen.() -> R): R = RegexWhen(string).block()

    class RegexWhen(val regexWhenArg: String) {
        inline fun <R: Any> Regex.then(block: (List<String>) -> R): R? = capture(regexWhenArg)?.let(block)        
        fun error(): Nothing = error("Unparsed string: $regexWhenArg")
    }

    fun hey(input: String): String {
        // Bob answers 'Sure.' if you ask him a question.
        // He answers 'Whoa, chill out!' if you yell at him.
        // He answers 'Calm down, I know what I'm doing!' if you yell a question at him.
        // He says 'Fine. Be that way!' if you address him without actually saying anything.
        // He answers 'Whatever.' to anything else.

        //if(input.trim() == "") return "Fine. Be that way!"
        return regexWhen(input.trim()) {
            Regex("""^$""").then {
                "Fine. Be that way!"
            } ?:
            Regex("""^([A-Z]|\s)+\?$""").then {
                "Calm down, I know what I'm doing!"
            } ?:
            Regex("""^.*\?$""").then {
                "Sure."
            } ?:
            Regex("""^(^[a-z])?(|[A-Z])+(^[a-z])?\!?$""").then {
                "Whoa, chill out!"
            } ?:
            "Whatever."
        }        
    }
}

// Test command
// kotlinc src/main/kotlin/*.kt; kotlin BobKt test
fun main(args: Array<String>){
   println(Bob.hey(args[0]))
}