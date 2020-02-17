import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram{
    private Map<Integer, Long> countingMap;
    private String word;
    public Anagram(String word){
        this.word = word.toLowerCase();
        this.countingMap = toCountingMap(word);
    }

    private Map<Integer, Long> toCountingMap(String word){
        return word.toLowerCase().chars()
                .mapToObj(Integer::valueOf)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );
    }
        
    public List<String> match(List<String> list){
        return list.stream()
                .filter(
                        i -> !this.word.equalsIgnoreCase(i)
                                && toCountingMap(i).equals(countingMap)
                )
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        new Anagram("test");
    }
}