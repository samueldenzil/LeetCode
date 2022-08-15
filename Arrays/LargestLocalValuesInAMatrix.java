// https://leetcode.com/problems/largest-local-values-in-a-matrix/
package Arrays;

import java.util.Arrays;

public class LargestLocalValuesInAMatrix {

    public static void main(String[] args) {
        int[][] gird = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 2, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        System.out.println(Arrays.deepToString(largestLocal(gird)));
    }

    public static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];

        int row = 0;
        int col = 0;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                ans[row][col] = getLargest(i, j, grid);
                col++;
                if (col == n - 2) {
                    row++;
                    col = 0;
                }
            }
        }

        return ans;
    }

    private static int getLargest(int row, int col, int[][] grid) {
        int max = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int temp = grid[row + i][col + j];
                max = Math.max(max, temp);
            }
        }
        return max;
    }
}
