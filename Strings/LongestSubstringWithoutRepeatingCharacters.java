// https://leetcode.com/problems/longest-substring-without-repeating-characters/
package Strings;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        int i = 0;
        int j = 0;

        int[] letter = new int[128];

        while (i < s.length() && j < s.length()) {
            char c = s.charAt(j);
            letter[c]++;

            // if there are repeating char in the window remove the
            // elements until there are no repeating char
            while (letter[c] > 1) {
                letter[s.charAt(i)]--;
                i++;
            }

            length = Math.max(length, j - i + 1);
            j++;
        }

        return length;
    }
}
