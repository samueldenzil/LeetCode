// https://leetcode.com/problems/verifying-an-alien-dictionary/
package Strings;

import java.util.Map;
import java.util.HashMap;

public class VerifyingAnAlienDictionary {

    public static void main(String[] args) {
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            if (!isValid(words[i - 1], words[i], map)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValid(String s, String t, Map<Character, Integer> map) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length() && s.charAt(i) == t.charAt(j)) {
            i++;
            j++;
        }

        if (i == s.length()) {
            return true;
        } else if (j == t.length()) {
            return false;
        } else {
            return map.get(s.charAt(i)) <= map.get(t.charAt(j));
        }
    }
}
