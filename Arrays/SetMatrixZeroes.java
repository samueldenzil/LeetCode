// https://leetcode.com/problems/set-matrix-zeroes/
package Arrays;

import java.util.Arrays;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /* public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // getting the position of element having value as 0
                    list.add(new int[]{i, j});
                }
            }
        }

        for (int[] element : list) {
            int row = element[0];
            int col = element[1];

            // setting its entire row and column to 0's.
            for (int i = 0; i < n; i++) {
                matrix[row][i] = 0;
            }
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
    } */
}
