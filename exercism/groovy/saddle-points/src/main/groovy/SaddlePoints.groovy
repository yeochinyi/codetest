class SaddlePoints {

    // Ref : http://docs.groovy-lang.org/next/html/documentation/working-with-collections.html

    // static getSaddlePoints(List<List<Integer>> matrix) {
    //     def maxList = matrix.collect { def v=it.max(); it.collect{ it == v } }
    //     def minList = matrix.transpose().collect { def v=it.min(); it.collect{ it == v } }.transpose()

    //     return maxList.indexed().findResults{ i,row->
    //         row.indexed().collect{ j, v ->
    //             v && minList[i][j] ? [i,j] : null
    //         } // https://stackoverflow.com/questions/3285241/remove-null-items-from-a-list-in-groovy vs .findAll{ it != null }
    //     }// Using collectMany vs .inject([]) {  sum, it -> sum += it }
    // }

    static getSaddlePoints(List<List<Integer>> matrix) {
        def maxList = matrix.collect { it.max() }
        def minList = matrix.transpose().collect { it.min() }

        // https://mrhaki.blogspot.com/2011/09/groovy-goodness-transform-items-into.html
        return matrix.indexed().collectMany{ i, row->
            row.indexed().findResults{ j, val ->
                val == maxList[i] && val == minList[j] ? [i,j] : null
            }
        }
    }
  
    static main(args){
        // Quick test on cli: groovy src/main/groovy/SaddlePoints.groovy "[[9, 8, 9], [5, 3, 5], [6, 6, 7]]"
        println SaddlePoints.getSaddlePoints(Eval.me(args[0]))
    }
}