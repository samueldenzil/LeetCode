// https://practice.geeksforgeeks.org/problems/257a9e27fb3e58255622c8dcb06e0919cc1c6c11/1
package All_Problems;

public class CoinsOfGeekland {

    public static void main(String[] args) {
        int[][] mat = {
            {1, 1, 1, 1, 1},
            {2, 2, 2, 2, 2},
            {3, 8, 6, 7, 3},
            {4, 4, 4, 4, 4},
            {5, 5, 5, 5, 5},
        };

        int N = mat.length;
        int K = 3;
        System.out.println(Maximum_Sum(mat, N, K));
    }

    // Using the concept of Prefix sum array
    static int Maximum_Sum(int[][] mat, int N, int K) {
        // Your code goes here
        int sum = Integer.MIN_VALUE;

        // converting matrix to prefix sum matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i - 1 >= 0)
                    mat[i][j] += mat[i - 1][j];

                if (j - 1 >= 0)
                    mat[i][j] += mat[i][j - 1];

                if (i - 1 >= 0 && j - 1 >= 0)
                    mat[i][j] -= mat[i - 1][j - 1];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int local = mat[i][j];

                if (i - K >= 0)
                    local -= mat[i - K][j];

                if (j - K >= 0)
                    local -= mat[i][j - K];

                if (i - K >= 0 && j - K >= 0)
                    local += mat[i - K][j - K];

                sum = Math.max(sum, local);
            }
        }

        return sum;
    }

    // Brute force approach
    /* static int Maximum_Sum(int[][] mat, int N, int K) {
        // Your code goes here
        int sum = 0;

        for (int i = 0; i < N - K + 1; i++) {
            for (int j = 0; j < N - K + 1; j++) {
                int currentSum = getSubMatrixSum(mat, i, j, N, K);
                sum = Math.max(sum, currentSum);
            }
        }

        return sum;
    }

    static int getSubMatrixSum(int[][] mat, int p, int q, int N, int K) {
        int sum = 0;

        for (int i = p; i < p + K; i++) {
            for (int j = q; j < q + K; j++) {
                sum += mat[i][j];
            }
        }

        return sum;
    } */
}
