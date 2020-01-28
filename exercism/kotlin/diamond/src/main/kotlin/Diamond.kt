class DiamondPrinter {

    fun printToList(letter: Char):String{
        var r = ""
        val dimension = (letter - 'A') * 2
        for (i in 0..dimension) {
            for (j in 0..dimension){
                val currentCharRow = if(i < dimension / 2) 'A' + i else 'A' + (dimension - i)
                val currentColumnDistance = letter - currentCharRow
                r += if(currentColumnDistance == j || currentColumnDistance == dimension - j) currentCharRow else '.'
            }
            r += "\n"
        }
        return r
    }
}


fun main(args: Array<String>){
   println(DiamondPrinter().printToList(args[0].single()))
}
