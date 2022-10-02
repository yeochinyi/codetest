import java.lang.IllegalArgumentException

class Triangle<out T : Number>(val a: T, val b: T, val c: T) {

    init{
        val isTriangle = a > 0 && b > 0 && c > 0 &&
                a + b >= c &&
                a + c >= b &&
                b + c >= a
        require(isTriangle)
    }
    private val sideGrouping = listOf(a, b, c).groupingBy { it }.eachCount().values.maxOrNull()!!

    val isEquilateral by lazy {
        sideGrouping == 3
    }
    val isIsosceles = sideGrouping >= 2
    val isScalene =  sideGrouping == 1
}

private operator fun Number.compareTo(i: Number) = toDouble().compareTo(i.toDouble())
private operator fun Number.plus(i: Number) = toDouble() + i.toDouble()
