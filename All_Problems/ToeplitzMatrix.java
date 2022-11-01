// https://leetcode.com/problems/toeplitz-matrix/
package All_Problems;

public class ToeplitzMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}
        };
        System.out.println(isToeplitzMatrix(matrix));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i - 1][j - 1] != matrix[i][j]) { // check whether each value is equal to the value of it's top-left neighbor.
                    return false;
                }
            }
        }

        return true;
    }
}
