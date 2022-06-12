// https://leetcode.com/problems/rotate-image/
package All_Problems;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void rotate(int[][] matrix) {
        // to rotate the matrix 90 degrees (clockwise)
        // step 1) get its transpose
        // step 2) reverse the columns

        int n = matrix.length;

        // transpose
        for (int r = 0; r < n; r++) {
            for (int c = r; c < n; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }

        // reverse
        for (int[] row : matrix) {
            int i = 0;
            int j = n - 1;

            while (i <= j) {
                int temp = row[i];
                row[i] = row[j];
                row[j] = temp;
                i++;
                j--;
            }
        }
    }
}
