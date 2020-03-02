class PhoneNumber {
    static String clean(String input) {
        input=input.replaceAll(/\W/,'')
        switch(input.length()){
            case 9: throw new Exception()
            case {it > 11}: throw new Exception()
            case 11: if(input[0]!='1') throw new Exception()
                return input.substring(1)
        }
        input        
    }
}
