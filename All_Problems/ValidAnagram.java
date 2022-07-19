// https://leetcode.com/problems/valid-anagram/
package All_Problems;

import java.util.Arrays;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            letters[c1 - 'a']++;
            letters[c2 - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }

        return true;
    }

    /* public static boolean isAnagram(String s, String t) {
        s = sortString(s);
        t = sortString(t);

        return s.equals(t);
    }

    public static String sortString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    } */
}
