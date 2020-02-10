import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PigLatinTranslator{

    // Ref:  https://www.vogella.com/tutorials/JavaRegularExpressions/article.html#java-regex-examples

    /**
     * Return pig latin translation of phrase
     * @param input
     * @return
     */
//    public String translate(String input){
//        return Arrays.stream(input.split(" ")).map(this::translateWord).collect(Collectors.joining(" "));
//    }

    private final Pattern PATTERN = Pattern.compile("^((?!xr|yt)(?:y|[^aeiou]*(?:qu)|[^aeiouy]*))?((?:xr|yt)?.*)");

    public String translate(String sentence) {
        String[] words = sentence.split(" ");
        ArrayList<String> result = new ArrayList<String>();
        String consonant = "";
        String restOfBody = "";

        for (String word:words) {
            Matcher m = PATTERN.matcher(word);

            if (m.matches()) {
                if (m.group(1) != null) {
                    consonant = m.group(1);
                }
                restOfBody = m.group(2);
                result.add(restOfBody + consonant + "ay");
            }
        }

        return String.join(" ", result);
    }

    // - **Rule 1**: If a word begins with a vowel sound, add an "ay" sound to the end of the word.
    //  Please note that "xr" and "yt" at the beginning of a word make vowel sounds (e.g. "xray" -> "xrayay", "yttria" -> "yttriaay").
    // - **Rule 2**: If a word begins with a consonant sound, move it to the end of the word
    //      and then add an "ay" sound to the end of the word. Consonant sounds can be made up of multiple consonants,
    //      a.k.a. a consonant cluster (e.g. "chair" -> "airchay").
    // - **Rule 3**: If a word starts with a consonant sound followed by "qu",
    //      move it to the end of the word, and then add an "ay" sound to the end of the word (e.g. "square" -> "aresquay").
    // - **Rule 4**: If a word contains a "y" after a consonant cluster or as the second letter in a two letter word
    //      it makes a vowel sound (e.g. "rhythm" -> "ythmrhay", "my" -> "ymay").

    private String translateWord(String input){

        // Rule 1
        if(Pattern.compile("^([aeiou]|xr|yt).*",Pattern.CASE_INSENSITIVE).matcher(input).matches()){
            return input + "ay";
        }

        Matcher m;
        // Rule 3
        m = Pattern.compile("^[^aeiou]?qu",Pattern.CASE_INSENSITIVE).matcher(input);
        if(m.find()){
            return input.substring(m.end()) + m.group() + "ay";
        }

        // Rule 4
        m = Pattern.compile("^([^aeiou]+)(y)",Pattern.CASE_INSENSITIVE).matcher(input);
        if(m.find()){
            return input.substring(m.end()-1) + m.group(1) + "ay";
        }

        // Rule 2
        m = Pattern.compile("^[^aeiou]+",Pattern.CASE_INSENSITIVE).matcher(input);
        if(m.find()){
            return input.substring(m.end()) + m.group() + "ay";
        }

        return "";
    }
}