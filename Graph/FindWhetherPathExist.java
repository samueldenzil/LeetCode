// https://practice.geeksforgeeks.org/problems/find-whether-path-exist5238/1
package Graph;

import java.util.Queue;
import java.util.LinkedList;

public class FindWhetherPathExist {

    public static void main(String[] args) {
        int[][] grid = {
                {3, 0, 3, 0, 0},
                {3, 0, 0, 0, 3},
                {3, 3, 3, 3, 3},
                {0, 2, 3, 0, 0},
                {3, 0, 0, 1, 3}
        };
        System.out.println(is_Possible(grid));
    }

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    //Function to find whether a path exists from the source to destination.
    public static boolean is_Possible(int[][] grid) {
        // Code here
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int row = 0;
        int col = 0;
        int[] end = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row = i;
                    col = j;
                } else if (grid[i][j] == 2) {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        visited[row][col] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            row = queue.peek().row;
            col = queue.peek().col;
            queue.poll();

            if (row == end[0] && col == end[1]) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nrow = row + dx[i];
                int ncol = col + dy[i];

                if (isValid(nrow, ncol, grid, visited, n)) {
                    queue.add(new Pair(nrow, ncol));
                    visited[nrow][ncol] = true;
                }
            }
        }

        return false;
    }

    private static boolean isValid(int row, int col, int[][] grid, boolean[][] visited, int n) {
        return row >= 0 && row < n && col >= 0 && col < n && (grid[row][col] == 2 || grid[row][col] == 3) && !visited[row][col];
    }
}
