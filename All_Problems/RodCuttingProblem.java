// https://www.codingninjas.com/codestudio/problems/rod-cutting-problem_800284
package All_Problems;

import java.util.Arrays;

public class RodCuttingProblem {

    public static void main(String[] args) {
        int n = 5;
        int[] price = {2, 5, 7, 8, 10};

        System.out.println(cutRod(price, n));
    }

    public static int cutRod(int[] price, int n) {
        int[] prev = new int[n + 1];

        // base case
        for (int N = 0; N <= n; N++) {
            prev[N] = N * price[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int N = 0; N <= n; N++) {
                int notTake = 0 + prev[N];
                int take = Integer.MIN_VALUE;
                int rodLength = ind + 1;
                if (rodLength <= N) {
                    take = price[ind] + prev[N - rodLength];
                }

                prev[N] = Math.max(take, notTake);
            }
        }

        return prev[n];
    }


    // TC: O(n * n)
    // SC: O(n * n)
    /* public static int cutRod(int[] price, int n) {
        // Write your code here.
        int[][] dp = new int[n][n + 1];

        // base case
        for (int N = 0; N <= n; N++) {
            dp[0][N] = N * price[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int N = 0; N <= n; N++) {
                int notTake = 0 + dp[ind - 1][N];
                int take = Integer.MIN_VALUE;
                int rodLength = ind + 1;
                if (rodLength <= N) {
                    take = price[ind] + dp[ind][N - rodLength];
                }

                dp[ind][N] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][n];
    } */


    // TC: O(n * n)
    // SC: O(n * n) + O(n)
    /* public static int cutRod(int[] price, int n) {
        // Write your code here.
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(n - 1, n, price, dp);
    }

    private static int helper(int ind, int N, int[] price, int[][] dp) {
        if (ind == 0) {
            return N * price[0];
        }

        if (dp[ind][N] != -1) {
            return dp[ind][N];
        }

        int notTake = 0 + helper(ind - 1, N, price, dp);
        int take = Integer.MIN_VALUE;
        int rodLength = ind + 1;
        if (rodLength <= N) {
            take = price[ind] + helper(ind, N - rodLength, price, dp);
        }

        return dp[ind][N] = Math.max(take, notTake);
    } */
}
