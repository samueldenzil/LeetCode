// https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1
package All_Problems;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class DistanceOfNearestCellHaving1 {

    static class Pair {
        int row;
        int col;
        int dist;

        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1}
        };
        int[][] ans = nearest(grid);
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }

    //Function to find distance of nearest 1 in the grid for each cell.
    public static int[][] nearest(int[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;

        int[][] distance = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int[] delRow = {0, 1, 0, -1};
        int[] delCol = {1, 0, -1, 0};

        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            int dist = queue.peek().dist;
            queue.poll();

            distance[row][col] = dist;

            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (isValid(nrow, ncol, grid, visited, n, m)) {
                    queue.add(new Pair(nrow, ncol, dist + 1));
                    visited[nrow][ncol] = true;
                }
            }
        }

        return distance;
    }

    private static boolean isValid(int row, int col, int[][] grid, boolean[][] visited, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 0 && !visited[row][col];
    }
}
