class Proverb {

    // recite proverb based on strings
    static recite(strings) {
        if(strings.isEmpty()) return ""

        def proverb = strings.collate(2,1,false).collect{
            "For want of a ${it.first()} the ${it.last()} was lost."
        }
        proverb << "And all for the want of a ${strings.head()}."
        proverb.join("\n")
        
    }

    static main(args){
        print new Proverb().recite(["1","2"])
    }
}