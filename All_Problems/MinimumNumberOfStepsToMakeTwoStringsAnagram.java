// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
package All_Problems;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {

    public static void main(String[] args) {
        String s = "bab", t = "aba";
        System.out.println(minSteps(s, t));
    }

    public static int minSteps(String s, String t) {
        int ans = 0;

        int[] letters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letters[c - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            letters[c - 'a']--;
        }

        for (int i = 0; i < letters.length; i++) {
            ans += Math.abs(letters[i]);
        }

        return ans / 2;
    }
}
