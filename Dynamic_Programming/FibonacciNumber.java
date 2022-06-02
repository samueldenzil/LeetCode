// https://leetcode.com/problems/fibonacci-number/
package Dynamic_Programming;

import java.util.Arrays;

public class FibonacciNumber {

    public static void main(String[] args) {
        int n = 30;
        System.out.println(fib(n));
    }

    // TC: O(n)
    // SC: O(1)
    public static int fib(int n) {
        int prev = 1;
        int prev2 = 0;

        if (n == 0) {
            return 0;
        }

        for (int i = 2; i <= n; i++) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }


    // TC: O(n)
    // SC: O(n)
    /* public static int fib(int n) {
        int[] dp = new int[n + 1];

        // Base case
        dp[0] = 0;
        if (n == 0) {
            return 0;
        }
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    } */


    // TC: O(n)
    // SC: O(n) + O(n)
    /* public static int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    private static int helper(int ind, int[] dp) {
        // Base case
        if (ind <= 1) {
            return ind;
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        return dp[ind] = helper(ind - 1, dp) + helper(ind - 2, dp);
    } */
}
