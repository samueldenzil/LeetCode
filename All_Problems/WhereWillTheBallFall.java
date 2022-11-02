// https://leetcode.com/problems/where-will-the-ball-fall/
package All_Problems;

import java.util.Arrays;

public class WhereWillTheBallFall {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, -1, -1},
                {1, 1, 1, -1, -1},
                {-1, -1, -1, 1, 1},
                {1, 1, 1, 1, -1},
                {-1, -1, -1, -1, -1}
        };
        System.out.println(Arrays.toString(findBall(grid)));
    }

    public static int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[n];

        for (int j = 0; j < n; j++) {
            ans[j] = dfs(0, j, grid, m, n);
        }

        return ans;
    }

    private static int dfs(int row, int col, int[][] grid, int m, int n) {
        if (col < 0 || col >= n) {  // outside the grid
            return -1;
        }
        if (row == m) {
            return col;
        }

        // checking for "V" shaped pattern between two boards
        if (col + 1 < n) {
            if (grid[row][col] == 1 && grid[row][col + 1] == -1) {
                return -1;
            }
        }
        if (col - 1 >= 0) {
            if (grid[row][col - 1] == 1 && grid[row][col] == -1) {
                return -1;
            }
        }

        if (grid[row][col] == 1) {
            return dfs(row + 1, col + 1, grid, m, n);
        } else {
            return dfs(row + 1, col - 1, grid, m, n);
        }
    }
}
