// https://leetcode.com/problems/minimum-falling-path-sum
package All_Problems;

import java.util.Arrays;

public class MinimumFallingPathSum {

    public static void main(String[] args) {
        int[][] matrix = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        System.out.println(minFallingPathSum(matrix));
    }

    // Memoization
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int min = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            int cost = helper(n - 1, j, matrix, n, dp);
            min = Math.min(min, cost);
        }

        return min;
    }

    private static int helper(int i, int j, int[][] matrix, int n, int[][] dp) {
        // Base case
        if (i < 0 || j < 0 || i >= n || j >= n) {
            return (int) 1e9;
        }
        if (i == 0) {
            return matrix[0][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int leftDiagonal = matrix[i][j] + helper(i - 1, j - 1, matrix, n, dp);
        int up = matrix[i][j] + helper(i - 1, j, matrix, n, dp);
        int rightDiagonal = matrix[i][j] + helper(i - 1, j + 1, matrix, n, dp);

        return dp[i][j] = Math.min(leftDiagonal, Math.min(up, rightDiagonal));
    }


    // Tabulation
    /* public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];

        // Base case
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal += (int) 1e9;
                }

                int up = matrix[i][j] + dp[i - 1][j];

                int rightDiagonal = matrix[i][j];
                if (j + 1 < n) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal += (int) 1e9;
                }

                dp[i][j] = Math.min(leftDiagonal, Math.min(up, rightDiagonal));
            }
        }


        int min = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }

        return min;
    } */


    // Tabulation + Space Optimization
    /* public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[] prev = new int[n];

        // Base case
        for (int j = 0; j < n; j++) {
            prev[j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += prev[j - 1];
                } else {
                    leftDiagonal += (int) 1e9;
                }

                int up = matrix[i][j] + prev[j];

                int rightDiagonal = matrix[i][j];
                if (j + 1 < n) {
                    rightDiagonal += prev[j + 1];
                } else {
                    rightDiagonal += (int) 1e9;
                }

                curr[j] = Math.min(leftDiagonal, Math.min(up, rightDiagonal));
            }
            prev = curr;
        }

        int min = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            min = Math.min(min, prev[j]);
        }

        return min;
    } */
}
