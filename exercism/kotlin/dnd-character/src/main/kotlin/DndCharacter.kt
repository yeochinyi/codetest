

import kotlin.random.Random

class DndCharacter {

    val strength: Int = ability()
    val dexterity: Int = ability()
    val constitution: Int = ability()
    val intelligence: Int = ability()
    val wisdom: Int = ability()
    val charisma: Int = ability()
    val hitpoints: Int = 10 + modifier(constitution)

    companion object {

        fun ability(): Int {
           return (1..4).map{ Random.nextInt(1, 6) }.sum()
        }

        fun modifier(score: Int): Int {
            var r = (score.toDouble() - 10.0)
            if(r < 0 ){
                r -= 1.0 
            }
            return (r / 2).toInt()

        }
    }

}
