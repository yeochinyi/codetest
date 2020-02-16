object PigLatin {

    // Translate sentence to pig latin
    fun translate(phrase: String): String = phrase
            .split(" ")
            .map{it.toLowerCase()}
            .joinToString(" ") { translateWord(it) }

    private operator fun Regex.contains(text: CharSequence): Boolean = this.matches(text)

    private fun applyRules(phrase: String, rule: Regex) = rule
            .find(phrase)!!
            .let{ it.groups[2]!!.value + it.groups[1]!!.value + "ay" }

    private fun translateWord(phrase: String): String {
        val rules1 = """^([aeiou]|xr|yt)(.*)$""".toRegex()
        val rules2 = """^([^aieou]+)([aeiout].*)$""".toRegex()
        val rules3 = """^([^aieou]?qu)(.*)$""".toRegex()
        val rules4 = """^([^aieou]+)(y.*)$""".toRegex()
        return with(phrase) {
            when (this) {
                in rules1 -> rules1.find(this)?.value + "ay"
                in rules4 -> applyRules(this, rules4)
                in rules3 -> applyRules(this, rules3)
                in rules2 -> applyRules(this, rules2)

                else -> ""
            }
        }

    }
}
