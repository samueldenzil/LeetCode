// https://leetcode.com/problems/first-unique-character-in-a-string/
package Strings;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        int[] letters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letters[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (letters[c - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
