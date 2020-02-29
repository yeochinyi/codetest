object ResistorColor {

    enum class ResistorColorValue = black, brown, red, orange, yellow, green, blue, violet, grey, white

    fun colorCode(input: String): Int = ResistorColorValue.valueOf(input).ordinal

    fun colors(): List<String> = ResistorColorValue.values().map { it.name }.toList()
}
