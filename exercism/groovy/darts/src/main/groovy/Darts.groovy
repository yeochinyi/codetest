class Darts {

    static final def SCORES = [1: 10, 5: 5, 10: 1]

    static int score(x, y) {
        def d = (x**2 + y**2)**(1/2)    
        SCORES.find { d <= it.key }?.value ?: 0
    }

    // static void main(args){
    //     Darts.score(args[0].toInteger(),args[1].toInteger())
    // }
}