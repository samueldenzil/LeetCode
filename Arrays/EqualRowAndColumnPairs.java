// https://leetcode.com/problems/equal-row-and-column-pairs/
package Arrays;

public class EqualRowAndColumnPairs {

    public static void main(String[] args) {
        int[][] grid = {
                {3, 2, 1},
                {1, 7, 6},
                {2, 7, 7}
        };
        System.out.println(equalPairs(grid));
    }

    public static int equalPairs(int[][] grid) {
        int n = grid.length;

        int count = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (isEqual(row, col, grid)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isEqual(int row, int col, int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            if (grid[row][i] != grid[i][col]) {
                return false;
            }
        }
        return true;
    }
}
