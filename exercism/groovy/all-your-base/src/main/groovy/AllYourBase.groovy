// Convert inputBase with digits to outputBase representation of numbers
class AllYourBase {

    private int total
    AllYourBase(Integer inputBase, List<Integer> digits) {        
        if(inputBase < 2) throw new ArithmeticException("inputBase < 2")
        total = digits.isEmpty() ? 0 : digits.reverse().indexed().collect { index, item ->
            if(item < 0 || item >= inputBase) throw new ArithmeticException("invalid digit=${item}")
            item * (inputBase ** index)
        }.sum()
    }

    def rebase(int outputBase) {
        if(outputBase < 2) throw new ArithmeticException("outputBase < 2")
        if(total == 0) return [0]
        int temp = total
        def output = []
        while(temp > 0){
            output.add(0, temp % outputBase)
            temp /= outputBase
        }
        output
    }

    // static void main(args){
    //     println new AllYourBase(10,[4,2]).rebase(2)
    // }
}