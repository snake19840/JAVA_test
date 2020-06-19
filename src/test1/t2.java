package test1;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class t2 {
    public static String HTMLEncode(String aText){
        final StringBuilder result = new StringBuilder();
        final StringCharacterIterator iterator = new StringCharacterIterator(aText);
        char character = iterator.current();
        while (character != CharacterIterator.DONE ){
            if (character == '<') {
                result.append("&lt;");
            }
            else if (character == '>') {
                result.append("&gt;");
            }
            else if (character == '&') {
                result.append("&amp;");
            }
            else if (character == '\\') {
                result.append("&quot;");
            }
            else {
//the char is not a special one
//add it to the result as is
                result.append(character);
            }
            character = iterator.next();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String a="123&re";
        String a2=t2.HTMLEncode(a);
        System.out.println(a2);
    }
}
