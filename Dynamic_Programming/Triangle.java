// https://www.codingninjas.com/codestudio/problems/triangle_1229398
package Dynamic_Programming;

import java.util.Arrays;

public class Triangle {

    public static void main(String[] args) {
        int[][] triangle = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };
        int n = triangle.length;
        System.out.println(minimumPathSum(triangle, n));
    }

    // TC: O(n * n)
    // SC: O(n)
    public static int minimumPathSum(int[][] triangle, int n) {
        int[] front = new int[n];

        // Base case
        for (int j = 0; j < n; j++) {
            front[j] = triangle[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            int[] curr = new int[n];
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + front[j];
                int diagonal = triangle[i][j] + front[j + 1];
                curr[j] = Math.min(down, diagonal);
            }
            front = curr;
        }

        return front[0];
    }


    // TC: O(n * n)
    // SC: O(n * n)
    /* public static int minimumPathSum(int[][] triangle, int n) {
        int[][] dp = new int[n][n];

        // Base case
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + dp[i + 1][j];
                int diagonal = triangle[i][j] + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diagonal);
            }
        }

        return dp[0][0];
    } */


    // TC: O(n * n)
    // SC: O(n) + O(n * n)
    /* public static int minimumPathSum(int[][] triangle, int n) {
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(0, 0, triangle, n, dp);
    }

    private static int helper(int i, int j, int[][] triangle, int n, int[][] dp) {
        // Base case
        if (i == n - 1) {
            return triangle[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = triangle[i][j] + helper(i + 1, j, triangle, n, dp);
        int diagonal = triangle[i][j] + helper(i + 1, j + 1, triangle, n, dp);

        return dp[i][j] = Math.min(down, diagonal);
    } */
}
