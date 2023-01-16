// https://leetcode.com/problems/increment-submatrices-by-one/
package All_Problems;

import java.util.Arrays;

public class IncrementSubmatricesByOne {

    public static void main(String[] args) {
        int n = 3;
        int[][] queries = {{1, 1, 2, 2}, {0, 0, 1, 1}};
        int[][] ans = rangeAddQueries(n, queries);
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];

        for (int[] query : queries) {
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];

            mat[row1][col1]++;
            if (col2 + 1 < n) {
                mat[row1][col2 + 1]--;
            }
            if (row2 + 1 < n) {
                mat[row2 + 1][col1]--;
            }
            if (row2 + 1 < n && col2 + 1 < n) {
                mat[row2 + 1][col2 + 1]++;
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 1; c < n; c++) {
                mat[r][c] += mat[r][c - 1];
            }
        }
        for (int r = 1; r < n; r++) {
            for (int c = 0; c < n; c++) {
                mat[r][c] += mat[r - 1][c];
            }
        }

        return mat;
    }
}
