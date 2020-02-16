class Anagram(private val source: String) {

    private val sourceMap = source.countMap()
    private val sourceLower = source.toLowerCase()

    fun <T>Collection<T>.countBy(): Map<T,Int> = this
            .groupBy { it }
            .map { it.key to it.value.size }.toMap()

    fun String.countMap(): Map<Char,Int> = this.toLowerCase().toList().countBy()

    fun match(anagrams: Collection<String>): Set<String> {
            return anagrams.filter { it.toLowerCase() != sourceLower && it.countMap() == sourceMap }.toSet()
    }
}
