data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(val data: List<List<Int>>) {
    // var saddlePoints: Set<MatrixCoordinate>
    // init {
    //// println("${data}")
    // if (data.isEmpty() || data[0].isEmpty()) {
    // saddlePoints = emptySet<MatrixCoordinate>()
    // } else {
    // val maxRows = mutableListOf<Int>()
    // val minCols = mutableListOf<Int>()
    // for (rows in data) {
    // maxRows.add(rows.maxOrNull()!!)
    // }
    // for (i in 0..data[0].size - 1) {
    // val cols = (0..(data.size - 1)).map { it -> data[it][i] }.toList()
    // minCols.add(cols.minOrNull()!!)
    // }

    // println("$data, max=${maxRows}, ${minCols}")
    // var r = mutableSetOf<MatrixCoordinate>()
    // for ((ri, rows) in data.withIndex()) {
    // for ((ci, v) in rows.withIndex()) {
    // if (v == maxRows[ri] && v == minCols[ci]) {
    // r.add(MatrixCoordinate(ri + 1, ci + 1))
    // }
    // }
    // }
    // saddlePoints = r
    // }
    // }
    // private val columns by lazy { (0 until data[0].size).map { i -> data.map { it[i] } } }
    private val columns by lazy { (0 until data[0].size).map { i -> data.map { it[i] } } }

    private val maxInRow by lazy { data.map { it.maxOrNull()!! } }

    private val minInCol by lazy { columns.map { it.minOrNull()!! } }

    val saddlePoints: Set<MatrixCoordinate> =
            data
                    .mapIndexed { x, row ->
                        row.mapIndexed { y, it ->
                            if (it == maxInRow[x] && it == minInCol[y]) {
                                MatrixCoordinate(x + 1, y + 1)
                            } else null
                        }
                    }
                    .flatten()
                    .filterNotNull()
                    .toSet()
}
