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
    /* private void bfs(int row, int col, int[][] grid, boolean[][] vis, int[] dx, int[] dy) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        vis[row][col] = true;

        while (!queue.isEmpty()) {
            row = queue.peek()[0];
            col = queue.poll()[1];
            queue.peek();

            for (int i = 0; i < 4; i++) {
                int newRow = row + dx[i];
                int newCol = col + dy[i];
                if (isValid(newRow, newCol, grid, vis)) {
                    queue.add(new int[]{newRow, newCol});
                    vis[newRow][newCol] = true;
                }
            }
        }
    } */

    private static boolean isValid(int row, int col, int[][] grid, boolean[][] vis, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1 && !vis[row][col];
    }
}
