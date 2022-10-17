// https://leetcode.com/problems/number-of-enclaves/
package All_Problems;

import java.util.Queue;
import java.util.LinkedList;

public class NumberOfEnclaves {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
        System.out.println(numEnclaves(grid));
    }

    // DFS Solution
    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && !vis[0][j]) {
                dfs(0, j, grid, vis, dx, dy);
            }
            if (grid[n - 1][j] == 1 && !vis[n - 1][j]) {
                dfs(n - 1, j, grid, vis, dx, dy);
            }
        }
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && !vis[i][0]) {
                dfs(i, 0, grid, vis, dx, dy);
            }
            if (grid[i][m - 1] == 1 && !vis[i][m - 1]) {
                dfs(i, m - 1, grid, vis, dx, dy);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int row, int col, int[][] grid, boolean[][] vis, int[] dx, int[] dy) {
        vis[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];

            if (isValid(nrow, ncol, grid, vis, n, m)) {
                dfs(nrow, ncol, grid, vis, dx, dy);
            }
        }
    }

    // BFS Solution
    /* public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && !vis[0][j]) {
                queue.add(new Pair(0, j));
                vis[0][j] = true;
            }
            if (grid[n - 1][j] == 1 && !vis[n - 1][j]) {
                queue.add(new Pair(n - 1, j));
                vis[n - 1][j] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && !vis[i][0]) {
                queue.add(new Pair(i, 0));
                vis[i][0] = true;
            }
            if (grid[i][m - 1] == 1 && !vis[i][m - 1]) {
                queue.add(new Pair(i, m - 1));
                vis[i][m - 1] = true;
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nrow = row + dx[i];
                int ncol = col + dy[i];

                if (isValid(nrow, ncol, grid, vis, n, m)) {
                    queue.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }
        return count;
    } */

    private static boolean isValid(int row, int col, int[][] grid, boolean[][] vis, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1 && !vis[row][col];
    }

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
