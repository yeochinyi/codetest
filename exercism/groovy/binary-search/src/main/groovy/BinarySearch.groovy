class BinarySearch<T extends Comparable> {
    List<T> data
    BinarySearch(List data) {
        this.data = data
    }

    // Get indexOf item on data using binary search or return -1 if not found
    int indexOf(T item) {
        if(this.data.isEmpty()) return -1
        int start = 0
        int end = this.data.size() - 1
        while(true){
 
            int mid = (start + end) / 2
            def midItem = this.data[mid]
            // println "start=$start, mid=$mid, end=$end"
            if(start == end){
                if(this.data[start] == item) return start
                return -1
            }             
            if(midItem == item) return mid            
            else if(midItem < item) start = mid + 1 //+1 as java integer divison is lower bound bias
            else end = mid
        }
    }

    // for cli test i.e groovy .\src\main\groovy\BinarySearch.groovy "[1, 3, 4, 6, 8, 9, 11]" 1
    static void main(args){
        println new BinarySearch(Eval.me(args[0])).indexOf(args[1].toInteger())
    }

}
