object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {
        require(leftStrand.length == rightStrand.length) { 
            "left and right strands must be of equal length" 
        }

        val zip = leftStrand zip rightStrand
        return zip.count { (a,b) -> a != b }
    }
}
