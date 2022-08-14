// https://leetcode.com/problems/rotting-oranges/
package Graph;

import java.util.Queue;
import java.util.LinkedList;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 2},
                {0, 1, 2},
                {2, 1, 1}
        };
        System.out.println(orangesRotting(grid));
    }

    static class Pair {
        int row;
        int col;
        int tm;

        Pair(int row, int col, int tm) {
            this.row = row;
            this.col = col;
            this.tm = tm;
        }
    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        int[][] vis = new int[m][n];
        int freshOranges = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int count = 0;
        int time = 0;
        while (!queue.isEmpty()) {
            Pair orange = queue.poll();
            time = Math.max(time, orange.tm);

            for (int i = 0; i < 4; i++) {
                int newRow = orange.row + dx[i];
                int newCol = orange.col + dy[i];

                if (isValid(newRow, newCol, grid, vis, m, n)) {
                    queue.add(new Pair(newRow, newCol, orange.tm + 1));
                    vis[newRow][newCol] = 2;
                    count++;
                }
            }
        }

        if (freshOranges != count) {
            return -1;
        }

        return time;
    }

    private static boolean isValid(int row, int col, int[][] grid, int[][] vis, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1 && vis[row][col] != 2;
    }
}
