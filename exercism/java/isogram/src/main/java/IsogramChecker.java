import java.util.HashMap;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        var m = new HashMap<Character,Boolean>();
        for(char a: phrase.toCharArray()){
            if(m.putIfAbsent(a,true)!=null){
                return false;
            };
        };
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsogramChecker().isIsogram(args[0]));
    }

}
