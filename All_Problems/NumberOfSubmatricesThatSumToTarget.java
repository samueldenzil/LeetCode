// https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
package All_Problems;

public class NumberOfSubmatricesThatSumToTarget {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
        };
        int target = 0;
        System.out.println(numSubmatrixSumTarget(matrix, target));
    }

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // prefix sum
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }

        // for (int[] row : matrix) {
        //     System.out.println(Arrays.toString(row));
        // }

        int ans = 0;
        for (int startRow = 0; startRow < m; startRow++) {
            for (int startCol = 0; startCol < n; startCol++) {
                ans += helper(startRow, startCol, matrix, target);
            }
        }

        return ans;
    }

    private static int helper(int startRow, int startCol, int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;

        for (int endRow = startRow; endRow < m; endRow++) {
            for (int endCol = startCol; endCol < n; endCol++) {
                int sum = matrix[endRow][endCol];
                if (startRow - 1 >= 0) {
                    sum -= matrix[startRow - 1][endCol];
                }
                if (startCol - 1 >= 0) {
                    sum -= matrix[endRow][startCol - 1];
                }
                if (startRow - 1 >= 0 && startCol - 1 >= 0) {
                    sum += matrix[startRow - 1][startCol - 1];
                }
                if (sum == target) {
                    count++;
                }
            }
        }

        return count;
    }
}
