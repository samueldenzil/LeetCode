// https://leetcode.com/problems/words-within-two-edits-of-dictionary/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class WordsWithinTwoEditsOfDictionary {

    public static void main(String[] args) {
        String[] queries = {"word", "note", "ants", "wood"}, dictionary = {"wood", "joke", "moat"};
        System.out.println(twoEditWords(queries, dictionary));
    }

    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (String word : queries) {
            if (doSomething(word, dictionary)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private static boolean doSomething(String q, String[] dictionary) {
        for (String dict : dictionary) {
            int diff = 0;
            for (int i = 0; i < q.length(); i++) {
                if (q.charAt(i) != dict.charAt(i)) {
                    diff++;
                }
            }
            if (diff <= 2) {
                return true;
            }
        }
        return false;
    }
}
