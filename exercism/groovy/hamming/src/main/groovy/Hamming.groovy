class Hamming {
    // return hamming distance between 2 strings
    def distance(strand1, strand2) {
        def ca1 = strand1.toCharArray()
        def ca2 = strand2.toCharArray()
        if(ca1.length != ca2.length) throw new ArithmeticException()
        return [ca1, ca2].transpose().sum{ it[0] == it[1] ? 0:1 } ?: 0
    }

}

