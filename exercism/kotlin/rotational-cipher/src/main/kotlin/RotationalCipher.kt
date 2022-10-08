class RotationalCipher(val i: Int) {
    fun encode(text: String): String {
        return text.map { it.rotate() }.joinToString("")
    }

    companion object {
        val CASES = listOf(
            ('A'..'Z'),
            ('a'..'z')
        ).map { it.toList() }
    }

    private fun Char.rotate(): Char =
        CASES.singleOrNull { this in it }?.let { x -> x.shift(this) } ?: kotlin.run { this }

    private fun List<Char>.shift(c: Char): Char = this[(this.indexOf(c) + i) % 26]
}

