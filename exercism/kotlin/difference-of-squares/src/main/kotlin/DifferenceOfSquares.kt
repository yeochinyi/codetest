class Squares(val s: Int) {

    fun sumOfSquares() = (1..s).map { Math.pow(it.toDouble(), 2.0) }.sum().toInt()
    fun squareOfSum() = Math.pow((1..s).sum().toDouble(), 2.0).toInt()

    fun difference() = squareOfSum() - sumOfSquares()
}
