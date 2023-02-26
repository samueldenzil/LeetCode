// https://leetcode.com/problems/path-with-maximum-gold/
package All_Problems;

public class PathWithMaximumGold {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}
        };
        System.out.println(getMaximumGold(grid));
    }

    public static int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    int curr = helper(i, j, grid, vis, dirs);
                    ans = Math.max(ans, curr);
                }
            }
        }

        return ans;
    }

    private static int helper(int i, int j, int[][] grid, boolean[][] vis, int[][] dirs) {
        vis[i][j] = true;
        int max = 0;
        for (int[] d : dirs) {
            int newI = i + d[0];
            int newJ = j + d[1];
            if (isValid(newI, newJ, grid, vis)) {
                max = Math.max(max, helper(newI, newJ, grid, vis, dirs));
            }
        }
        vis[i][j] = false;
        return grid[i][j] + max;
    }

    private static boolean isValid(int i, int j, int[][] grid, boolean[][] vis) {
        int m = grid.length;
        int n = grid[0].length;
        return i >= 0 && i < m && j >= 0 && j < n && grid[i][j] != 0 && !vis[i][j];
    }
}
