// https://practice.geeksforgeeks.org/problems/7366ce450d84b55391fc787a681c4d60de359e72/1
package All_Problems;

import java.util.Queue;
import java.util.LinkedList;

public class ShortestXYDistanceInGrid {

    public static void main(String[] args) {
        char[][] grid = {
                {'X', 'O', 'O', 'O'},
                {'O', 'Y', 'O', 'Y'},
                {'X', 'X', 'O', 'O'},
                {'O', 'Y', 'O', 'O'}
        };
        System.out.println(shortestXYDist(grid, grid.length, grid[0].length));
    }

    public static int shortestXYDist(char[][] grid, int n, int m) {
        // code here
        Queue<int[]> queue = new LinkedList<>(); // row, col
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'X') {
                    queue.add(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int row = queue.peek()[0];
                int col = queue.peek()[1];
                queue.poll();

                if (grid[row][col] == 'Y') {
                    return dist;
                }

                for (int i = 0; i < 4; i++) {
                    int newRow = row + dx[i];
                    int newCol = col + dy[i];
                    if (isValid(newRow, newCol, vis, n, m)) {
                        queue.add(new int[]{newRow, newCol});
                        vis[newRow][newCol] = true;
                    }
                }
            }
            dist++;
        }

        return dist;
    }

    private static boolean isValid(int row, int col, boolean[][] vis, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m && !vis[row][col];
    }
}
