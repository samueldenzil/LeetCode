// https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/
package Strings;

public class LengthOfTheLongestAlphabeticalContinuousSubstring {

    public static void main(String[] args) {
        String s = "abacaba";
        System.out.println(longestContinuousSubstring(s));
    }

    public static int longestContinuousSubstring(String s) {
        int n = s.length();
        char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        int i = 0;
        int j = 0;
        int max = 0;

        while (i < n) {
            int index = s.charAt(j) - 'a';
            while (j < n && index < 26 && s.charAt(j) == alphabets[index]) {
                j++;
                index++;
            }
            max = Math.max(max, j - i);
            i = j;
        }

        return max;
    }
}
