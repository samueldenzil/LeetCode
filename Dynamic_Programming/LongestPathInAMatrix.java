// https://practice.geeksforgeeks.org/problems/longest-path-in-a-matrix3019/1
package Dynamic_Programming;

import java.util.Arrays;

public class LongestPathInAMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 9},
                {5, 3, 8},
                {4, 6, 7}
        };
        System.out.println(longestIncreasingPath(matrix));
    }

    public static int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int length = 1 + helper(i, j, matrix, n, m, dp);
                max = Math.max(max, length);
            }
        }

        return max;
    }

    private static int helper(int i, int j, int[][] matrix, int n, int m, int[][] dp) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int max = 0;
        for (int d = 0; d < dx.length; d++) {
            int newI = i + dx[d];
            int newJ = j + dy[d];

            if (isValid(newI, newJ, n, m) && matrix[newI][newJ] > matrix[i][j]) {
                int curr = 1 + helper(newI, newJ, matrix, n, m, dp);
                max = Math.max(max, curr);
            }
        }

        return dp[i][j] = max;
    }

    private static boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return false;
        }
        return true;
    }

}
