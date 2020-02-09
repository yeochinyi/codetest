import java.util.regex.Pattern;

public class PigLatinTranslator{

// - **Rule 1**: If a word begins with a vowel sound, add an "ay" sound to the end of the word.
//  Please note that "xr" and "yt" at the beginning of a word make vowel sounds (e.g. "xray" -> "xrayay", "yttria" -> "yttriaay").
// - **Rule 2**: If a word begins with a consonant sound, move it to the end of the word
//      and then add an "ay" sound to the end of the word. Consonant sounds can be made up of multiple consonants,
//      a.k.a. a consonant cluster (e.g. "chair" -> "airchay").
// - **Rule 3**: If a word starts with a consonant sound followed by "qu",
//      move it to the end of the word, and then add an "ay" sound to the end of the word (e.g. "square" -> "aresquay").
// - **Rule 4**: If a word contains a "y" after a consonant cluster or as the second letter in a two letter word
//      it makes a vowel sound (e.g. "rhythm" -> "ythmrhay", "my" -> "ymay").

// Ref:  https://www.vogella.com/tutorials/JavaRegularExpressions/article.html#java-regex-examples
    public String translate(String input){
        if(Pattern.compile("^([a,e,i,o,u]|xr|yt).*",Pattern.CASE_INSENSITIVE).matcher(input).matches()){
            return input + "ay";
        }
        if(Pattern.compile("^(([^a,e,i,o,u]|)).*",Pattern.CASE_INSENSITIVE).matcher(input).matches()){
            input = input + "ay";
        }
        return "";
    }
}