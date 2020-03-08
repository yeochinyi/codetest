class NucleotideCount {

    static count(strand) {        
        def m = ['A':0, 'C':0, 'G':0, 'T':0] + 
            // strand.inject([:]){ acc, it -> if(acc[it]) acc[it]++ else acc[it] = 1; acc }
            strand.toList().countBy {it}
        if(m.keySet().size() > 4){
            throw new Exception("Invalid input")
        }
        m
    }
}