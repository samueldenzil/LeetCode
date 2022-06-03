// https://leetcode.com/problems/transpose-matrix
package All_Problems;

import java.util.Arrays;

class TransposeMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] ans = transpose(matrix);
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] newMatrix = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }

        return newMatrix;
    }
}
