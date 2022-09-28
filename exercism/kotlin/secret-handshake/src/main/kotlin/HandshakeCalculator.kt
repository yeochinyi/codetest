object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> {
        var n = number
        var s = ArrayList<Signal>()
        var c = 0
        while (n > 0) {
            // print("$n")
            var b = n and 1
            if (b == 1) {
                if (Signal.values().size < c + 1) {
                    return s.reversed()
                }
                s += Signal.values().get(c)
            }
            n = n shr 1
            c++
        }
        return s
    }
}
