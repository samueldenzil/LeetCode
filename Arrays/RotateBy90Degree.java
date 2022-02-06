// https://practice.geeksforgeeks.org/problems/rotate-by-90-degree0356/1
package Arrays;

import java.util.Arrays;

public class RotateBy90Degree {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        rotate(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    static void rotate(int[][] matrix) {
        // Code Here
        int n = matrix.length;

        // finding out the transpose of the matrix
        for (int r = 0; r < n; r++) {
            for (int c = r; c < n; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }

        // swapping the rows in the matrix
        for (int r = 0; r < n / 2; r++) {
            int[] temp = matrix[r];
            matrix[r] = matrix[n - r - 1];
            matrix[n - r - 1] = temp;
        }
    }
}
