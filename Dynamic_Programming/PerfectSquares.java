// https://leetcode.com/problems/perfect-squares/
package Dynamic_Programming;

import java.util.Arrays;

public class PerfectSquares {

    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(1, n, dp);
    }

    private static int helper(int ind, int T, int[] dp) {
        // base case
        if (T == 0) {
            return 0;
        }
        if (ind * ind > T) {
            return (int) 1e9;
        }

        if (dp[T] != -1) {
            return dp[T];
        }

        int notTake = helper(ind + 1, T, dp);

        int take = (int) 1e9;
        int num = ind * ind;
        if (num <= T) {
            take = 1 + helper(ind, T - num, dp);
        }

        return dp[T] = Math.min(take, notTake);
    }
}
