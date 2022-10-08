// class Robot {
// init {
// reset()
// }
// lateinit var backname: String

// val name: String
// get() = backname
// fun random(isDigit: Boolean): Int {
// if (isDigit) {
// return kotlin.random.Random.nextInt(9) + '0'.toInt()
// } else {
// return kotlin.random.Random.nextInt(26) + 'A'.toInt()
// }
// }
// companion object Set {
// val s = mutableSetOf<String>()
// }
// fun reset() {
// while (true) {
// val temp =
// "AA111"
//// .map {
//// println(it)
//// it
//// }
// .map { random(it == '1').toChar() }
//// .map {
//// println(it)
//// it
//// }
// .joinToString("")
// if (!Robot.s.contains(temp)) {
// backname = temp
// Robot.s.add(temp)
// return
// }
// }
// }

private val random = java.util.Random()

private fun List<*>.randomSample(n: Int) = (0 until n).map { this[random.nextInt(this.size)] }

private val names = mutableSetOf<String>()
private val letters = ('A'..'Z').toList()
private val numbers = ('0'..'9').toList()

class Robot {
    var name: String
    init {
        name = generateName()
    }
    fun reset() {
        name = generateName()
    }
    private tailrec fun generateName(): String {
        val name = letters.randomSample(2).plus(numbers.randomSample(3)).joinToString("")
        return when {
            names.add(name) -> name
            else -> generateName()
        }
    }
}
