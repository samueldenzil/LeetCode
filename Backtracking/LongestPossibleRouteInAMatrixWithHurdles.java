// https://practice.geeksforgeeks.org/problems/longest-possible-route-in-a-matrix-with-hurdles/1
package Backtracking;

public class LongestPossibleRouteInAMatrixWithHurdles {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 0, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        System.out.println(longestPath(matrix, matrix.length, matrix[0].length, 0, 0, 1, 7));
    }

    public static int longestPath(int[][] mat, int n, int m, int xs, int ys, int xd, int yd) {
        // edge case
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0) {
            return -1;
        }

        int[] ans = new int[1];
        helper(xs, ys, xd, yd, mat, 0, ans);
        return ans[0];
    }

    private static void helper(int i, int j, int x, int y, int[][] mat, int currPathLength, int[] ans) {
        // base case
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] == 0 || mat[i][j] == 2) {
            return;
        }
        if (i == x && j == y) {
            ans[0] = Math.max(ans[0], currPathLength);
            return;
        }

        mat[i][j] = 2;  // mat[i][j] = 2 means that we have visited the current cell

        helper(i, j + 1, x, y, mat, currPathLength + 1, ans);
        helper(i + 1, j, x, y, mat, currPathLength + 1, ans);
        helper(i, j - 1, x, y, mat, currPathLength + 1, ans);
        helper(i - 1, j, x, y, mat, currPathLength + 1, ans);

        // resetting the value
        mat[i][j] = 1;
    }
}
