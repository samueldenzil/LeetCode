// https://leetcode.com/problems/palindrome-partitioning-ii/
package Dynamic_Programming;

import java.util.Arrays;

public class PalindromePartitioningII {

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s));
    }

    public static int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(0, s, n, dp) - 1;
    }

    private static int helper(int idx, String s, int n, int[] dp) {
        if (idx >= n) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int min = Integer.MAX_VALUE;
        for (int i = idx; i < n; i++) {
            if (isPalindrome(s, idx, i)) {
                int curr = 1 + helper(i + 1, s, n, dp);
                min = Math.min(min, curr);
            }
        }

        return dp[idx] = min;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
