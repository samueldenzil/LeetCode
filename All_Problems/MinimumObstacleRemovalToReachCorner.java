// https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/
package All_Problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumObstacleRemovalToReachCorner {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(minimumObstacles(grid));
    }

    public static int minimumObstacles(int[][] grid) {
        // consider passing through an obstacles will cost you 1 coin
        // so try to reach the destination will min cost
        int m = grid.length;
        int n = grid[0].length;

        // min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));    // row, col, cost
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        pq.add(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int row = pq.peek()[0];
            int col = pq.peek()[1];
            int cost = pq.peek()[2];
            pq.poll();

            if (row == m - 1 && col == n - 1) {
                return dist[m - 1][n - 1];
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + dx[i];
                int newCol = col + dy[i];
                if (isValid(newRow, newCol, m, n) && cost + grid[newRow][newCol] < dist[newRow][newCol]) {
                    pq.add(new int[]{newRow, newCol, cost + grid[newRow][newCol]});
                    dist[newRow][newCol] = cost + grid[newRow][newCol];
                }
            }
        }

        return dist[m - 1][n - 1];
    }

    private static boolean isValid(int row, int col, int m, int n) {
        return row >= 0 && col >= 0 && row < m && col < n;
    }
}
