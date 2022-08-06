package All_Problems;

import java.util.Arrays;

public class MinimumInsertionStepsToMakeAStringPalindrome {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(minInsertions(s));
    }

    // TC: O(n * n)
    // SC: O(2 * n)
    public static int minInsertions(String s) {
        int n = s.length();

        int[] prev = new int[n + 1];

        // base case
        // for (int j = 0; j <= n; j++) {
        //     dp[0][j] = 0;
        // }
        // for (int i = 0; i <= n; i++) {
        //     dp[i][n] = 0;
        // }

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[n + 1];
            for (int j = n - 1; j >= 0; j--) {
                char c1 = s.charAt(i - 1);
                char c2 = s.charAt(j);

                if (c1 == c2) {
                    curr[j] = 1 + prev[j + 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j + 1]);
                }
            }
            prev = curr;
        }

        int lps = prev[0];
        return n - lps;
    }


    // TC: O(n * n)
    // SC: O(n * n)
    /* public static int minInsertions(String s) {
        int n = s.length();

        int[][] dp = new int[n + 1][n + 1];

        // base case
        // for (int j = 0; j <= n; j++) {
        //     dp[0][j] = 0;
        // }
        // for (int i = 0; i <= n; i++) {
        //     dp[i][n] = 0;
        // }

        for (int i = 1; i <= n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                char c1 = s.charAt(i - 1);
                char c2 = s.charAt(j);

                if (c1 == c2) {
                    dp[i][j] = 1 + dp[i - 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
            }
        }

        int lps = dp[n][0];
        return n - lps;
    } */


    // TC: O(n * n)
    // SC: O(n * n) + O(n + n)
    /* public static int minInsertions(String s) {
        int n = s.length();

        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int lps = helper(n, 0, s, dp);
        return n - lps;
    }

    private static int helper(int i, int j, String s, int[][] dp) {
        if (i == 0 || j == s.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        char c1 = s.charAt(i - 1);
        char c2 = s.charAt(j);

        if (c1 == c2) {
            return dp[i][j] = 1 + helper(i - 1, j + 1, s, dp);
        }
        return dp[i][j] = Math.max(helper(i - 1, j, s, dp), helper(i, j + 1, s, dp));
    } */
}
