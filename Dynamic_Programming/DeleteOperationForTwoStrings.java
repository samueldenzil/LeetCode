// https://leetcode.com/problems/delete-operation-for-two-strings
package Dynamic_Programming;

import java.util.Arrays;

public class DeleteOperationForTwoStrings {

    public static void main(String[] args) {
        String word1 = "leetcode";
        String word2 = "etco";

        System.out.println(minDistance(word1, word2));
    }

    // TC: O(n1 * n2)
    // SC: O(2 * n2)
    public static int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int[] prev = new int[n2 + 1];

        for (int i = 0; i < n1 + 1; i++) {
            int[] curr = new int[n2 + 1];
            for (int j = 0; j < n2 + 1; j++) {
                // Base case
                if (i == 0 || j == 0) {
                    curr[j] = i + j;
                    continue;
                }

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                    continue;
                }

                // if char are not equal
                int removeFromW1 = 1 + prev[j];
                int removeFromW2 = 1 + curr[j - 1];

                curr[j] = Math.min(removeFromW1, removeFromW2);
            }
            prev = curr;
        }

        return prev[n2];
    }


    // TC: O(n1 * n2)
    // SC: O(n1 * n2)
    /* public static int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i < n1 + 1; i++) {
            for (int j = 0; j < n2 + 1; j++) {
                // Base case
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                    continue;
                }

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }

                // if char are not equal
                int removeFromW1 = 1 + dp[i - 1][j];
                int removeFromW2 = 1 + dp[i][j - 1];

                dp[i][j] = Math.min(removeFromW1, removeFromW2);
            }
        }

        return dp[n1][n2];
    } */


    // TC: O(n1 * n2)
    // SC: O(min(n1, n2) + O(n1 * n2)
    /* public static int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1][n2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(n1 - 1, n2 - 1, word1, word2, dp);
    }

    private static int helper(int i, int j, String w1, String w2, int[][] dp) {
        // Base case
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (w1.charAt(i) == w2.charAt(j)) {
            return dp[i][j] = helper(i - 1, j - 1, w1, w2, dp);
        }

        // if char are not equal
        int removeFromW1 = 1 + helper(i - 1, j, w1, w2, dp);
        int removeFromW2 = 1 + helper(i, j - 1, w1, w2, dp);

        return dp[i][j] = Math.min(removeFromW1, removeFromW2);
    } */
}
