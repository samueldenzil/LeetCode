// https://leetcode.com/problems/shortest-common-supersequence/
package Dynamic_Programming;

import java.util.Arrays;

public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        String str1 = "brute", str2 = "groot";
        System.out.println(shortestCommonSupersequence(str1, str2));
    }

    public static String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        // base case
        // for (int j = 0; j <= n; j++) {
        //     dp[0][j] = 1;
        // }
        // for (int i = 0; j <= m; i++) {
        //     dp[i][0] = 1;
        // }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = str1.charAt(i - 1);
                char c2 = str2.charAt(j - 1);

                if (c1 == c2) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = m;
        int j = n;

        while (i > 0 && j > 0) {
            char c1 = str1.charAt(i - 1);
            char c2 = str2.charAt(j - 1);
            if (c1 == c2) {
                sb.append(c1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(c1);
                i--;
            } else {
                sb.append(c2);
                j--;
            }
        }

        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }



    /* public static String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int lcs = helper(m, n, str1, str2, dp);

        StringBuilder sb = new StringBuilder();
        int i = m;
        int j = n;

        while (i > 0 && j > 0) {
            char c1 = str1.charAt(i - 1);
            char c2 = str2.charAt(j - 1);
            if (c1 == c2) {
                sb.append(c1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(c1);
                i--;
            } else {
                sb.append(c2);
                j--;
            }
        }

        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }

    private static int helper(int i, int j, String str1, String str2, int[][] dp) {
        if (i == 0 || j == 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        char c1 = str1.charAt(i - 1);
        char c2 = str2.charAt(j - 1);

        if (c1 == c2) {
            return dp[i][j] = 1 + helper(i - 1, j - 1, str1, str2, dp);
        }
        return dp[i][j] = Math.max(helper(i - 1, j, str1, str2, dp), helper(i, j - 1, str1, str2, dp));
    } */
}
