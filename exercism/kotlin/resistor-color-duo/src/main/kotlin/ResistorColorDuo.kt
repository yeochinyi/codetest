object ResistorColorDuo {

    // return a 2 digit value for the color of resistor bands
    // fun value(vararg colors: Color) =
    //         colors.take(2).map{Color.values().indexOf(it)}.joinToString("").toInt()
    fun value(vararg colors: Color): Int = "${colors[0].ordinal}${colors[1].ordinal}".toInt()

}
