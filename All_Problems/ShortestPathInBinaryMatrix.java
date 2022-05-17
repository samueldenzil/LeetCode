// https://leetcode.com/problems/shortest-path-in-binary-matrix/
package All_Problems;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    private static class Pair {
        private int x;
        private int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length - 1;

        if (grid[0][0] == 1 || grid[n][n] == 1) {
            return -1;
        }

        Queue<Pair> queue = new LinkedList<>();

        int level = 0;

        queue.add(new Pair(0, 0));
        grid[0][0] = 2;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Pair head = queue.poll();
                int x = head.x;
                int y = head.y;

                if (x == n && y == n) {
                    return level + 1;
                }

                for (int j = x - 1; j <= x + 1; j++) {
                    for (int k = y - 1; k <= y + 1; k++) {
                        if (isValid(grid, j, k)) {
                            queue.add(new Pair(j, k));
                            grid[j][k] = 2;
                        }
                    }
                }
            }
            level++;
        }

        return -1;
    }

    private static boolean isValid(int[][] grid, int x, int y) {
        int n = grid.length - 1;

        if (x < 0 || y < 0 || x > n || y > n || grid[x][y] >= 1) {
            return false;
        }

        return true;
    }
}

