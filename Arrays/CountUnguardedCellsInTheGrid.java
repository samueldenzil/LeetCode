// https://leetcode.com/problems/count-unguarded-cells-in-the-grid/
package Arrays;

public class CountUnguardedCellsInTheGrid {

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] guards = {{1, 1}};
        int[][] walls = {{0, 1}, {1, 0}, {2, 1}, {1, 2}};
        System.out.println(countUnguarded(m, n, guards, walls));
    }

    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // matrix[i][j] == 0    -> unguarded
        // matrix[i][j] == 1    -> guard or wall
        // matrix[i][j] == 2    -> guarded
        int[][] matrix = new int[m][n];

        for (int[] guard : guards) {
            int x = guard[0];
            int y = guard[1];
            matrix[x][y] = 1;
        }

        for (int[] wall : walls) {
            int x = wall[0];
            int y = wall[1];
            matrix[x][y] = 1;
        }

        for (int[] guard : guards) {
            int x = guard[0];
            int y = guard[1];
            // checking the east direction
            for (int i = y + 1; i < n; i++) {
                if (matrix[x][i] == 1) {
                    break;
                } else {
                    matrix[x][i] = 2;
                }
            }
            // checking the west direction
            for (int i = y - 1; i >= 0; i--) {
                if (matrix[x][i] == 1) {
                    break;
                } else {
                    matrix[x][i] = 2;
                }
            }
            // checking the north direction
            for (int i = x - 1; i >= 0; i--) {
                if (matrix[i][y] == 1) {
                    break;
                } else {
                    matrix[i][y] = 2;
                }
            }
            // checking the south direction
            for (int i = x + 1; i < m; i++) {
                if (matrix[i][y] == 1) {
                    break;
                } else {
                    matrix[i][y] = 2;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
