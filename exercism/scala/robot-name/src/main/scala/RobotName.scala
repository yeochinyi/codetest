import scala.util.Random.nextInt
import scala.util.Random
import collection.mutable

object NameGenerator{
    val alreadySet = mutable.HashSet.empty[String]
    var counter = 0

     def  getName():String = {
        if(counter >= 676000) {
            return "Maxed!"
        }
        val r = new Random(System.currentTimeMillis())
        while(true){            
            val name = f"${('A' to 'Z')(nextInt(26))}${('A' to 'Z')(nextInt(26))}${nextInt(999)}%03d"
            printf("alreadySet=%d, name=%s\n",alreadySet.size, name)
            if(!(alreadySet contains name)){
                counter+=1
                alreadySet += name
                return name                
            }
        }   
        return "Error!"     
    }
}

class Robot{
    var name: String = ""
    reset()
    def reset(){
        name = NameGenerator.getName()
    }

}
