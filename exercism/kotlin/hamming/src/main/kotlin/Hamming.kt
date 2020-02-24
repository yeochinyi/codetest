object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {
        if(leftStrand.length != rightStrand.length){
            throw IllegalArgumentException("left and right strands must be of equal length")
        }
        val zip = leftStrand.toCharArray() zip rightStrand.toCharArray()
        return zip.count { (a,b) -> a != b }
    }
}
