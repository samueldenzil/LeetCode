// https://leetcode.com/problems/word-pattern/
package Strings;

import java.util.Map;
import java.util.HashMap;

public class WordPattern {

    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        // edge case
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map1.containsKey(c)) {
                if (!words[i].equals(map1.get(c))) {
                    return false;
                }
            }
            if (map2.containsKey(words[i])) {
                if (map2.get(words[i]) != c) {
                    return false;
                }
            }
            map1.put(c, words[i]);
            map2.put(words[i], c);
        }

        return true;
    }
}
