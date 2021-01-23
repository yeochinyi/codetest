class Matrix(private val matrixAsString: String) {

    // val cleanString = matrixAsString.replace("\\s+".toRegex(), " ")

    var cleanString = ""

    init {
        println("matrixAsString=${matrixAsString}end")

        for (c in matrixAsString){
            if(c != ' '){
                cleanString += c
            } 
            else if(!cleanString.isNullOrEmpty()) {
                val l = cleanString.last()
                if(l != ' ' && l != '\n'){
                    cleanString += c
                }
            }
        }
        println("cleanString=${cleanString}end")
    }

    val rowMatrix = cleanString.split("\n").map { it.split(" ").map{ str -> str.toInt() } }
    val colMatrix = (1..rowMatrix[0].size).toList().map { c-> 
            (1..rowMatrix.size).toList().map {
                r->rowMatrix[r-1][c-1]
        }
    }
    init {
        println("rowMatrix=${rowMatrix}")
        println("colMatrix=${colMatrix}")
    }
    

    fun column(colNr: Int): List<Int> {
        return colMatrix[colNr - 1]
    }

    fun row(rowNr: Int): List<Int> {
        return rowMatrix[rowNr - 1]
    }

}
