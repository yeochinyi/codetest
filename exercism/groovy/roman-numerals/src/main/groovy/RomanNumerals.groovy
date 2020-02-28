class RomanNumerals {
    //  I=1, V=5, 
    // X=10, L=50, 
    // C=100, D=500, 
    // M=1K
    RomanNumerals() {
        Integer.metaClass.getRoman = { ->
            // RETURN the roman representation of an Integer here
        }
    }
}
