// https://leetcode.com/problems/unique-morse-code-words/
package All_Problems;

import java.util.Set;
import java.util.HashSet;

public class UniqueMorseCodeWords {

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] morseTable = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();

        for (String word : words) {
            String code = getMorseCode(word, morseTable);
            set.add(code);
        }

        return set.size();
    }

    private static String getMorseCode(String word, String[] morseTable) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            sb.append(morseTable[index]);
        }
        return sb.toString();
    }
}
