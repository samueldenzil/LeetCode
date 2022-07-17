// https://leetcode.com/problems/out-of-boundary-paths/
package Dynamic_Programming;

import java.util.Arrays;

public class OutOfBoundaryPaths {

    public static void main(String[] args) {
        int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
        System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
    }

    private static int MOD = (int) 1e9 + 7;

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        return helper(startRow, startColumn, maxMove, m, n, dp) % MOD;
    }

    private static int helper(int i, int j, int moves, int m, int n, int[][][] dp) {
        // base case
        if (isOut(i, j, m, n)) {
            return 1;
        }
        if (moves == 0) {
            return 0;
        }

        if (dp[i][j][moves] != -1) {
            return dp[i][j][moves];
        }

        int top = helper(i - 1, j, moves - 1, m, n, dp) % MOD;
        int down = helper(i + 1, j, moves - 1, m, n, dp) % MOD;
        int left = helper(i, j - 1, moves - 1, m, n, dp) % MOD;
        int right = helper(i, j + 1, moves - 1, m, n, dp) % MOD;

        return dp[i][j][moves] = (top + down) % MOD + (left + right) % MOD;
    }

    private static boolean isOut(int i, int j, int m, int n) {
        if (i < 0 || i == m || j < 0 || j == n) {
            return true;
        }
        return false;
    }
}
