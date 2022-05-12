// https://leetcode.com/problems/count-sorted-vowel-strings/
package Dynamic_Programming;

import java.util.Arrays;

public class CountSortedVowelStrings {

    public static void main(String[] args) {
        int n = 50;
        System.out.println(countVowelStrings(n));
    }

    public static int countVowelStrings(int n) {
        int ans = 0;
        int[] dp = new int[5];
        Arrays.fill(dp, 1);


        for (int i = 2; i <= n; i++) {
            for (int j = 3; j >= 0; j--) {
                dp[j] = dp[j] + dp[j + 1];
            }
        }

        for (int i : dp) {
            ans += i;
        }

        return ans;
    }

    // Backtracking Approach - TLE
    /* public static int countVowelStrings(int n) {
        char[] vowel = {'a', 'e', 'i', 'o', 'u'};
        int[] count = new int[1];

        helper(vowel, n, 0, "", count);
        return count[0];
    }

    private static void helper(char[] vowel, int length, int start, String currentString, int[] count) {
        if (length == 0) {
            count[0]++;
            return;
        }

        for (int i = start; i < vowel.length; i++) {
            helper(vowel, length - 1, i, currentString + vowel[i], count);
        }
    } */
}
