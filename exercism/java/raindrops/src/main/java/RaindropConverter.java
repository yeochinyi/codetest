import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Convert number to raindrop sounds
 */
class RaindropConverter {

    String convert(int number) {

        var map = new LinkedHashMap<Integer, String>();
        map.put(3, "Pling");
        map.put(5, "Plang");
        map.put(7, "Plong");

        String reduce = map.entrySet().stream()
                .filter(kv -> number % kv.getKey() == 0).map(Map.Entry::getValue)
                .reduce("", (sum, e) -> sum + e);

        return reduce.equals("") ? Integer.toString(number) : reduce;
    }

    public static void main(String[] args) {
        System.out.println(new RaindropConverter().convert(1));
    }

}
