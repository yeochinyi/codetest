object BeerSong {
    fun verses(startBottles: Int, takeDown: Int):String{
        var ret = ""
        for(x in startBottles downTo takeDown){
            val bottle = if(x==1)"bottle" else "bottles"
            val nextbottle = if(x==2)"bottle" else "bottles"
            if(!ret.isEmpty()){
                ret += "\n"
            }
            ret += when(x){
                0 ->
"""No more bottles of beer on the wall, no more bottles of beer.
Go to the store and buy some more, 99 bottles of beer on the wall.
"""
                1 ->
"""1 bottle of beer on the wall, 1 bottle of beer.
Take it down and pass it around, no more bottles of beer on the wall.
"""
                else ->
"""${x} ${bottle} of beer on the wall, ${x} ${bottle} of beer.
Take one down and pass it around, ${x-1} ${nextbottle} of beer on the wall.
"""
            }
        }
        return ret
    }
}
