class ProteinTranslation {

    static proteins(strand) {

        def proteinMap = [
            ['AUG']                     : 'Methionine',
            ['UUU', 'UUC']              : 'Phenylalanine',
            ['UUA', 'UUG']              : 'Leucine',
            ['UCU', 'UCC', 'UCA', 'UCG'] : 'Serine',
            ['UAU', 'UAC']              : 'Tyrosine',
            ['UGU', 'UGC']             : 'Cysteine',
            ['UGG']                     : 'Tryptophan',
            ['UAA', 'UAG', 'UGA']       : 'STOP'
            ]
            .collect{ a,b -> a.collectEntries{ [it, b]} }.inject([:]){ acc, i ->  acc.putAll(i); acc }

        println proteinMap
        def list = []

        // for(def i=0;i < strand.size(); i+=3){
        //     //http://grails.asia/groovy-substring
        //     def condon = strand[i..i+2]
        // for (def condon in (strand =~ /.../)){
        // for (seq in strand.toList().collate(3)) {
        //     def condon = seq.join()
        //     def protein = proteinMap[condon]
        //     if(protein == 'STOP'){
        //         break
        //     }
        //     list += protein
        // }
        
        // return list
        return strand.collect()
            .collate(3)
            .collect { proteinMap[it.join()] }
            .takeWhile { it != 'STOP' }

    }

    static main(args){
        println ProteinTranslation.proteins("UGC")
    }
}