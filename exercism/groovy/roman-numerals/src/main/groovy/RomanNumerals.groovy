class RomanNumerals {
    //  I=1, V=5, 
    // X=10, L=50, 
    // C=100, D=500, 
    // M=1K

    // last 2 chars are 'blanks'
    def digits = "IVXLCDM--"

    RomanNumerals() {
        Integer.metaClass.getRoman = { ->
            return delegate.toString().reverse().toList().withIndex().collect { v, i ->
                def (ones, fives, tens) = [0,1,2].collect{ digits.charAt(i*2+it).toString() }
                def val = v as int
                switch(val){
                    case 1..3: ones * val
                    break
                    case 4..5:  ones * (5-val) + fives
                    break
                    case 6..8: fives + ones * (val-5)
                    break
                    case 9: ones * (10-val) + tens
                    break
                }
            }.findAll{it}.reverse().join("")
        }
    }

    static main(args){
        new RomanNumerals()
        println 9.roman
    }
}
