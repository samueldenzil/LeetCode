// https://leetcode.com/problems/interleaving-string/
package Dynamic_Programming;

import java.util.Arrays;

public class InterleavingString {

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int l = s3.length();

        if (n + m != l) {
            return false;
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(0, 0, s1, s2, s3, dp);
    }

    private static boolean helper(int i, int j, String s1, String s2, String s3, int[][] dp) {
        if (i == s1.length() && j == s2.length()) {
            return true;
        }

        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            boolean takeFromS1 = helper(i + 1, j, s1, s2, s3, dp);
            boolean takeFromS2 = false;
            if (!takeFromS1) {
                takeFromS2 = helper(i, j + 1, s1, s2, s3, dp);
            }

            boolean result = takeFromS1 || takeFromS2;
            dp[i][j] = result ? 1 : 0;

            return result;
        } else if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            boolean takeFromS1 = helper(i + 1, j, s1, s2, s3, dp);
            dp[i][j] = takeFromS1 ? 1 : 0;
            return takeFromS1;
        } else if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            boolean takeFromS2 = helper(i, j + 1, s1, s2, s3, dp);
            dp[i][j] = takeFromS2 ? 1 : 0;
            return takeFromS2;
        } else {
            dp[i][j] = 0;
            return false;
        }
    }
}
