object Raindrops {

    // returns raindrop sounds
    fun convert(n: Int): String {
        val sounds = mapOf(3 to "Pling", 5 to "Plang", 7 to "Plong")
            .filter { n % it.key == 0 }
            .map{ it.value }
            .joinToString("")
        return if(sounds.isEmpty()) "${n}" else sounds
    }
}
