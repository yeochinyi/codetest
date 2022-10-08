object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        return phrase.lowercase()
                .replace("[.:!&@$%^&]".toRegex(), "")
                .split(" ", "\n", "\t", ",")
                .map { it.removeSurrounding("'") }
                .filter { it != "" }
                .groupBy { it }
                // .map { it.key to it.value.size }
                .mapValues { it.value.size }
        // .toMap()
    }
}
