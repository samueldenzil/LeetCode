// https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/
package All_Problems;

import java.util.Arrays;

public class DifferenceBetweenOnesAndZerosInRowAndColumn {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1},
                {1, 0, 1},
                {0, 0, 1}
        };
        int[][] ans = onesMinusZeros(grid);
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] colCountArr = new int[n][2];
        int[][] rowCountArr = new int[m][2];

        for (int j = 0; j < n; j++) {
            colCountArr[j] = rowCount(grid, j);
        }
        for (int i = 0; i < m; i++) {
            rowCountArr[i] = colCount(grid, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = rowCountArr[i][1] + colCountArr[j][1] - rowCountArr[i][0] - colCountArr[j][0];
            }
        }
        return grid;
    }

    private static int[] colCount(int[][] grid, int row) {
        int n = grid[0].length;
        int zero = 0;
        int one = 0;
        for (int i = 0; i < n; i++) {
            if (grid[row][i] == 0) {
                zero++;
            } else {
                one++;
            }
        }
        return new int[]{zero, one};
    }

    private static int[] rowCount(int[][] grid, int col) {
        int m = grid.length;
        int zero = 0;
        int one = 0;
        for (int i = 0; i < m; i++) {
            if (grid[i][col] == 0) {
                zero++;
            } else {
                one++;
            }
        }
        return new int[]{zero, one};
    }
}
