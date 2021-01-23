class Matrix(private val matrixAsString: String) {

    val matrix = matrixAsString.lines().map { it.trim().split("\\s+".toRegex()).map(String::toInt) }

    fun column(colNr: Int): List<Int> = matrix.map { it[colNr - 1] }

    fun row(rowNr: Int): List<Int> = matrix[rowNr - 1]
}