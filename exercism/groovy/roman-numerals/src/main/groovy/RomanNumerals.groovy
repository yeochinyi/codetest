class RomanNumerals {
    //  I=1, V=5, 
    // X=10, L=50, 
    // C=100, D=500, 
    // M=1K

    // last 2 chars are 'blanks'
    def digits = "IVXLCDM--"

    RomanNumerals() {
        Integer.metaClass.getRoman = { ->

            def ret = ""
            delegate.toString().reverse().eachWithIndex { v, i ->
                def (ones, fives, tens) = [0,1,2].collect{ digits.charAt(i*2+it).toString() }
                def text = ""
                switch(v as int){
                    case 1..3: text = ones * val
                    break
                    case 4..5: text = ones * (5-val) + fives
                    break
                    case 6..8: text = fives + ones * (val-5)
                    break
                    case 9: text =  ones * (10-val) + tens
                }
                ret = text + ret
            }
            return ret

            
        }
    }

    static main(args){
        new RomanNumerals()
        println 2856.roman
    }
}
