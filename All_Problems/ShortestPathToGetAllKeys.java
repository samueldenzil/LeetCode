// https://leetcode.com/problems/shortest-path-to-get-all-keys/
package All_Problems;

import java.util.Queue;
import java.util.LinkedList;

public class ShortestPathToGetAllKeys {

    public static void main(String[] args) {
        String[] grid = {"@.a..", "###.#", "b.A.B"};
        System.out.println(shortestPathAllKeys(grid));
    }

    public static int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<int[]> queue = new LinkedList<>(); // x, y, steps, currentKeyStatusDecimal

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '@') {
                    queue.add(new int[]{i, j, 0, 0});
                } else if (grid[i].charAt(j) - 'a' >= 0 && grid[i].charAt(j) - 'a' < 6) {
                    count++;
                }
            }
        }

        int finalKeyStatusDecimal = (int) (Math.pow(2, count) - 1);

        boolean[][][] vis = new boolean[m][n][finalKeyStatusDecimal + 1];

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            int steps = temp[2];
            int currentKeyStatusDecimal = temp[3];

            // base case
            if (currentKeyStatusDecimal == finalKeyStatusDecimal) {
                return steps;
            }

            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (isValid(newX, newY, m, n, grid)) {
                    char ch = grid[newX].charAt(newY);

                    if (ch - 'A' >= 0 && ch - 'A' < 6) { // lock
                        if (!vis[newX][newY][currentKeyStatusDecimal]
                                && ((currentKeyStatusDecimal >> (ch - 'A') & 1) == 1)) { // have the key to this corresponding lock
                            queue.add(new int[]{newX, newY, steps + 1, currentKeyStatusDecimal});
                            vis[newX][newY][currentKeyStatusDecimal] = true;
                        }
                    } else if (ch - 'a' >= 0 && ch - 'a' < 6) { // key
                        int newKeyStatusInDecimal = 1 << (ch - 'a') | currentKeyStatusDecimal;
                        if (!vis[newX][newY][newKeyStatusInDecimal]) {
                            queue.add(new int[]{newX, newY, steps + 1, newKeyStatusInDecimal});
                            vis[newX][newY][newKeyStatusInDecimal] = true;
                        }
                    } else { // '.'
                        if (!vis[newX][newY][currentKeyStatusDecimal]) {
                            queue.add(new int[]{newX, newY, steps + 1, currentKeyStatusDecimal});
                            vis[newX][newY][currentKeyStatusDecimal] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }

    private static boolean isValid(int x, int y, int m, int n, String[] grid) {
        return x >= 0 && x < m && y >= 0 && y < n && grid[x].charAt(y) != '#';
    }
}
