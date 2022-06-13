// https://leetcode.com/problems/minimum-path-cost-in-a-grid/
package All_Problems;

import java.util.Arrays;

public class MinimumPathCostInAGrid {

    public static void main(String[] args) {
        int[][] grid = {
                {5, 3},
                {4, 0},
                {2, 1}
        };
        int[][] moveCost = {{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}};

        System.out.println(minPathCost(grid, moveCost));
    }

    // Tabulation + Space Optimization
    public static int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;

        int[] front = new int[n];

        // Base case
        for (int j = 0; j < n; j++) {
            front[j] = grid[m - 1][j];
        }

        for (int i = m - 2; i >= 0; i--) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    int val = grid[i][j];
                    int total = val + moveCost[val][k] + front[k];
                    min = Math.min(min, total);
                }

                curr[j] = min;
            }
            front = curr;
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, front[j]);
        }

        return min;
    }


    // Tabulation
    /* public static int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        // Base case
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = grid[m - 1][j];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    int val = grid[i][j];
                    int curr = val + moveCost[val][k] + dp[i + 1][k];
                    min = Math.min(min, curr);
                }

                dp[i][j] = min;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[0][j]);
        }

        return min;
    } */


    // Memoization
    /* public static int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int min = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            int path = helper(0, j, grid, moveCost, m, n, dp);
            min = Math.min(min, path);
        }

        return min;
    }

    private static int helper(int i, int j, int[][] grid, int[][] moveCost, int m, int n, int[][] dp) {
        // Base case
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return (int) 1e9;
        }
        if (i == m - 1) {
            return grid[m - 1][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            int val = grid[i][j];
            int curr = val + moveCost[val][k] + helper(i + 1, k, grid, moveCost, m, n, dp);
            min = Math.min(min, curr);
        }

        return dp[i][j] = min;
    }  */
}
