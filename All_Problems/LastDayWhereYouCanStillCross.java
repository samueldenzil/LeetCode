// https://leetcode.com/problems/last-day-where-you-can-still-cross/
package All_Problems;

import java.util.LinkedList;
import java.util.Queue;

public class LastDayWhereYouCanStillCross {

    public static void main(String[] args) {
        int row = 3, col = 3;
        int[][] cells = {{1, 2}, {2, 1}, {3, 3}, {2, 2}, {1, 1}, {1, 3}, {2, 3}, {3, 2}, {3, 1}};
        System.out.println(latestDayToCross(row, col, cells));
    }

    public static int latestDayToCross(int row, int col, int[][] cells) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int start = 0;
        int end = cells.length;

        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isPossibleToCross(row, col, dirs, cells, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    private static boolean isPossibleToCross(int row, int col, int[][] dirs, int[][] cells, int days) {
        int[][] grid = new int[row][col];
        for (int i = 0; i < days; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 0) {
                queue.add(new int[]{0, i});
                grid[0][i] = -1;
            }
        }

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            if (x == row - 1) {
                return true;
            }

            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (isValid(newX, newY, row, col, grid)) {
                    queue.add(new int[]{newX, newY});
                    grid[newX][newY] = -1;
                }
            }
        }

        return false;
    }

    private static boolean isValid(int x, int y, int row, int col, int[][] grid) {
        return x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 0;
    }
}
