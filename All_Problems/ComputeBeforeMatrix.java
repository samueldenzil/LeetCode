// https://practice.geeksforgeeks.org/problems/85781966a9db2a1ac17eaaed26a947eba5740d56/1
package All_Problems;

import java.util.Arrays;

public class ComputeBeforeMatrix {

    public static void main(String[] args) {
        int[][] after = {
                {1, 3, 6},
                {3, 7, 11}
        };

        int[][] before = computeBeforeMatrix(after.length, after[0].length, after);
        for (int[] row : before) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] computeBeforeMatrix(int N, int M,int[][] after ){
        // Just do the reverse of calculating the prefix matrix
        int[][] before = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i - 1 >= 0) {
                    before[i][j] -= after[i - 1][j];
                }
                if (j - 1 >= 0) {
                    before[i][j] -= after[i][j - 1];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    before[i][j] += after[i - 1][j - 1];
                }
                before[i][j] += after[i][j];
            }
        }

        return before;
    }
}
