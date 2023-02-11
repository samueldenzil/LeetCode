// https://leetcode.com/problems/as-far-from-land-as-possible/
package Graph;

import java.util.Queue;
import java.util.LinkedList;

public class AsFarFromLandAsPossible {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };
        System.out.println(maxDistance(grid));
    }

    public static int maxDistance(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int distance = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];
                for (int j = 0; j < 4; j++) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if (isValid(newX, newY, n, grid, vis)) {
                        queue.add(new int[]{newX, newY});
                        vis[newX][newY] = true;
                    }
                }
            }
            distance++;
        }

        return distance != 0 ? distance : -1;
    }

    private static boolean isValid(int x, int y, int n, int[][] grid, boolean[][] vis) {
        return x >= 0 && y >= 0 && x < n && y < n && !vis[x][y] && grid[x][y] == 0;
    }
}
