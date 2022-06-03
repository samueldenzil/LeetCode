// https://www.codingninjas.com/codestudio/problems/maximum-path-sum-in-the-matrix_797998
package Dynamic_Programming;

import java.util.Arrays;

public class MaximumPathSumInTheMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}
        };
        System.out.println(getMaxPathSum(matrix));
    }

    // TC: O(n * m)
    // SC: O(n)
    public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] prev = new int[m];

        // Base case
        for (int j = 0; j < m; j++) {
            prev[j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += prev[j - 1];
                } else {
                    leftDiagonal += (int) (-1e9);
                }

                int up = matrix[i][j] + prev[j];

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += prev[j + 1];
                } else {
                    rightDiagonal += (int) (-1e9);
                }

                curr[j] = Math.max(leftDiagonal, Math.max(up, rightDiagonal));
            }
            prev = curr;
        }

        int max = prev[0];

        for (int j = 1; j < m; j++) {
            max = Math.max(max, prev[j]);
        }

        return max;
    }


    // TC: O(n * m)
    // SC: O(n * m)
    /* public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        // Base case
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal += (int) (-1e9);
                }

                int up = matrix[i][j] + dp[i - 1][j];

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal += (int) (-1e9);
                }

                dp[i][j] = Math.max(leftDiagonal, Math.max(up, rightDiagonal));
            }
        }

        int max = dp[n - 1][0];

        for (int j = 1; j < m; j++) {
            max = Math.max(max, dp[n - 1][j]);
        }

        return max;
    } */


    // TC: O(n * m)
    // SC: O(n * m) + O(n)
    /* public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int max = Integer.MIN_VALUE;

        for (int j = 0; j < m; j++) {
            max = Math.max(max, helper(n - 1, j, matrix, dp));
        }

        return max;
    }

    private static int helper(int i, int j, int[][] matrix, int[][] dp) {
        // Base case
        if (j < 0 || j >= matrix[0].length) {
            return (int) -1e9;
        }
        if (i == 0) {
            return matrix[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int leftDiagonal = matrix[i][j] + helper(i - 1, j - 1, matrix, dp);
        int up = matrix[i][j] + helper(i - 1, j, matrix, dp);
        int rightDiagonal = matrix[i][j] + helper(i - 1, j + 1, matrix, dp);

        return dp[i][j] = Math.max(leftDiagonal, Math.max(up, rightDiagonal));
    } */
}
