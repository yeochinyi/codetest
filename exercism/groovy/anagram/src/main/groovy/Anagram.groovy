class Anagram {
    def subject
    def subjectMap

    Anagram(subject){
        this.subject = subject.toLowerCase()
        this.subjectMap = toCounter(this.subject)
    }

    def toCounter(text){
//        return text.toCharArray().toList().countBy{it}
        def x= text.toList().sort()
        println("x=${x}")
        x
    }

    def find(candidates) {
        //  https://stackoverflow.com/questions/1871372/how-to-check-if-a-list-contains-a-sublist
       return candidates.findAll { 
           def itLower = it.toLowerCase()
           this.subject != itLower && subjectMap == toCounter(itLower)
        }
    }

    static void main(args){
        println new Anagram(args[0]).find(args.tail())
    }
}