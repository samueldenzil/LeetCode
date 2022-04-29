// https://leetcode.com/problems/path-with-minimum-effort/
package All_Problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    public static void main(String[] args) {
        int[][] heights = {{1, 10, 6, 7, 9, 10, 4, 9}};
        System.out.println(minimumEffortPath(heights));
    }

    public static int minimumEffortPath(int[][] heights) {
        int[] dir = {0, 1, 0, -1, 0};
        int m = heights.length;
        int n = heights[0].length;

        int[][] efforts = new int[m][n];

        for (int[] effort : efforts) {
            Arrays.fill(effort, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        efforts[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});  // starting from the 0, 0 with effort as 0

        while (!pq.isEmpty()) {
            int[] head = pq.poll();
            int x = head[1];
            int y = head[2];
            int currentEffort = head[0];

            if (x == m - 1 && y == n - 1) {
                return currentEffort;
            }

            for (int k = 0; k < 4; k++) {
                int newX = x + dir[k];
                int newY = y + dir[k + 1];
                /*
                 * k = 0     x, y + 1 -> right
                 * k = 1     x + 1, y -> bottom
                 * k = 2     x, y - 1 -> left
                 * k = 3     x - 1, y -> top
                 */

                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int newEffort = Math.max(currentEffort, Math.abs(heights[newX][newY] - heights[x][y]));

                    if (newEffort < efforts[newX][newY]) {
                        efforts[newX][newY] = newEffort;
                        pq.offer(new int[]{newEffort, newX, newY});
                    }
                }
            }
        }

        return 0;
    }
}
