class Hamming {
    // return hamming distance between 2 strings
    def distance(strand1, strand2) {
        def (ca1, ca2) = [strand1, strand2]*.toCharArray()        
        if(ca1.length != ca2.length) throw new ArithmeticException("strands are unequal")
        return [ca1, ca2].transpose().count{ a, b -> a != b }
    }

    // static main(args){
    //     print new Hamming().distance("12345", "12000")
    // }
}

