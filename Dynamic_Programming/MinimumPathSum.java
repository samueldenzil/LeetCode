// https://leetcode.com/problems/minimum-path-sum/
package Dynamic_Programming;

import java.util.Arrays;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(grid));
    }

    // TC: O(m * n)
    // SC: O((m - 1) + (n - 1)) + O(m * n)
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(m - 1, n - 1, grid, dp);
    }

    private static int helper(int i, int j, int[][] grid, int[][] dp) {
        // Base case
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        // If we go outside the grid
        if (i < 0 || j < 0) {
            return (int) 1e9;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = grid[i][j] + helper(i - 1, j, grid, dp);
        int left = grid[i][j] + helper(i, j - 1, grid, dp);

        return dp[i][j] = Math.min(up, left);
    }


    // TC: O(m * n)
    // SC: O(m * n)
    /* public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Base case
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }

                int up = grid[i][j];
                if (i - 1 >= 0) {
                    up += dp[i - 1][j];
                } else {
                    up += (int) 1e9;
                }

                int left = grid[i][j];
                if (j - 1 >= 0) {
                    left += dp[i][j - 1];
                } else {
                    left += (int) 1e9;
                }

                dp[i][j] = Math.min(up, left);
            }
        }

        return dp[m - 1][n - 1];
    } */


    // TC: O(m * n)
    // SC: O(n)
    /* public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];

            for (int j = 0; j < n; j++) {
                // Base case
                if (i == 0 && j == 0) {
                    curr[j] = grid[i][j];
                    continue;
                }

                int up = grid[i][j];
                if (i - 1 >= 0) {
                    up += prev[j];
                } else {
                    up += (int) 1e9;
                }

                int left = grid[i][j];
                if (j - 1 >= 0) {
                    left += curr[j - 1];
                } else {
                    left += (int) 1e9;
                }

                curr[j] = Math.min(up, left);
            }
            prev = curr;
        }

        return prev[n - 1];
    } */
}
