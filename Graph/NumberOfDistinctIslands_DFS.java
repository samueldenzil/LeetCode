// https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1
package Graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class NumberOfDistinctIslands_DFS {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };

        System.out.println(countDistinctIslands(grid));
    }

    public static int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Set<List<String>> set = new HashSet<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    List<String> list = new ArrayList<>();
                    dfs(i, j, i, j, grid, vis, list, dx, dy);
                    set.add(list);
                }
            }
        }

        return set.size();
    }

    private static void dfs(int row, int col, int baseRow, int baseCol, int[][] grid, boolean[][] vis, List<String> list, int[] dx, int[] dy) {
        vis[row][col] = true;
        list.add(toString(row - baseRow, col - baseCol));

        for (int i = 0; i < 4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];

            if (isValid(nrow, ncol, grid, vis)) {
                dfs(nrow, ncol, baseRow, baseCol, grid, vis, list, dx, dy);
            }
        }
    }

    private static String toString(int row, int col) {
        return row + " " + col;
    }

    private static boolean isValid(int row, int col, int[][] grid, boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;
        return row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1 && !vis[row][col];
    }
}
