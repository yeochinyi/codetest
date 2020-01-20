class Raindrops {

    def convert(num) {

        [3: 'Pling', 5: 'Plang', 7: 'Plong'].findAll{num % it.key == 0}*.value.join() ?: "${num}"

        // def s = ""
        // if(num%3==0){
        //     s += "Pling"
        // }
        // if(num%5==0){
        //     s += "Plang"
        // }
        // if(num%7==0){
        //     s += "Plong"
        // }
        // if(s.length() == 0){
        //     return "" + num
        // }
        // return s
    }

}
