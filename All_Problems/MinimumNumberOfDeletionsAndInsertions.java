// https://www.codingninjas.com/codestudio/problems/can-you-make_4244510
package All_Problems;

import java.util.Arrays;

public class MinimumNumberOfDeletionsAndInsertions {

    public static void main(String[] args) {
        String str = "abcd";
        String ptr = "anc";
        System.out.println(canYouMake(str, ptr));
    }

    // TC: O(n * m)
    // SC: O(2 * m)
    public static int canYouMake(String str, String ptr) {
        // Write your code here.
        int n = str.length();
        int m = ptr.length();

        int[] prev = new int[m + 1];

        // base case
        // for (int j = 0; j <= m; j++) {
        //     prev[j] = 0;
        // }

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                char c1 = str.charAt(i - 1);
                char c2 = ptr.charAt(j - 1);

                if (c1 == c2) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }

        int lcs = prev[m];

        return n + m - (2 * lcs);
    }


    // TC: O(n * m)
    // SC: O(n * m)
    /* public static int canYouMake(String str, String ptr) {
        // Write your code here.
        int n = str.length();
        int m = ptr.length();

        int[][] dp = new int[n + 1][m + 1];

        // base case
        // for (int j = 0; j <= m; j++) {
        //     dp[0][j] = 0;
        // }
        // for (int i = 0; i <= n; i++) {
        //     dp[i][0] = 0;
        // }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char c1 = str.charAt(i - 1);
                char c2 = ptr.charAt(j - 1);

                if (c1 == c2) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcs = dp[n][m];

        return n + m - (2 * lcs);
    } */


    // TC: O(n * m)
    // SC: O(n * m) + O(n + m)
    /* public static int canYouMake(String str, String ptr) {
        // Write your code here.
        int n = str.length();
        int m = ptr.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int lcs = helper(n, m, str, ptr, dp);

        return n + m - (2 * lcs);
    }

    private static int helper(int i, int j, String str, String ptr, int[][] dp) {
        // base case
        if (i == 0 || j == 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        char c1 = str.charAt(i - 1);
        char c2 = ptr.charAt(j - 1);
        if (c1 == c2) {
            return dp[i][j] = 1 + helper(i - 1, j - 1, str, ptr, dp);
        }
        return dp[i][j] = Math.max(helper(i - 1, j, str, ptr, dp), helper(i, j - 1, str, ptr, dp));
    } */
}
