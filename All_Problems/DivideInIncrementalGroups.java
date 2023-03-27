// https://practice.geeksforgeeks.org/problems/c239059f6d110e6778cc2f2a1ab58ffd0a3d64ca/1
package All_Problems;

import java.util.Arrays;

public class DivideInIncrementalGroups {

    public static void main(String[] args) {
        int n = 8, k = 4;
        System.out.println(countWaysToDivide(n, k));
    }

    public static int countWaysToDivide(int n, int k) {
        int[][][] dp = new int[n + 1][n + 1][k + 1];
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }
        return helper(1, n, k, n, dp);
    }

    private static int helper(int num, int W, int k, int n, int[][][] dp) {
        // base case
        if (k == 0 && W == 0) {
            return 1;
        }
        if (k == 0 || W == 0 || num > n) {
            return 0;
        }

        if (dp[num][W][k] != -1) {
            return dp[num][W][k];
        }

        int take = 0;
        if (num <= W) {
            take = helper(num, W - num, k - 1, n, dp);
        }
        int notTake = helper(num + 1, W, k, n, dp);

        return dp[num][W][k] = take + notTake;
    }
}
