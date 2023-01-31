// https://leetcode.com/problems/n-th-tribonacci-number/
package All_Problems;

import java.util.Arrays;

public class NthTribonacciNumber {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(tribonacci(n));
    }

    // Memoization
    // TC: O(n)
    // SC: O(n) + O(n)
    public static int tribonacci(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    private static int helper(int ind, int[] dp) {
        if (ind == 0) {
            return 0;
        } else if (ind == 1 || ind == 2) {
            return 1;
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        return dp[ind] = helper(ind - 1, dp) + helper(ind - 2, dp) + helper(ind - 3, dp);
    }


    // Tabulation
    // TC: O(n)
    // SC: O(n)
    /* public static int tribonacci(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        if (n == 0) {
            return dp[0];
        }
        dp[1] = 1;
        if (n == 1) {
            return dp[1];
        }
        dp[2] = 1;
        if (n == 2) {
            return dp[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    } */


    // Tabulation + Space Optimization
    // TC: O(n)
    // SC: O(1)
    /* public static int tribonacci(int n) {
        int prev = 1;
        int prev1 = 1;
        int prev2 = 0;

        if (n == 0) {
            return prev2;
        } else if (n == 1) {
            return prev1;
        } else if (n == 2) {
            return prev;
        }

        for (int i = 3; i <= n; i++) {
            int curr = prev + prev1 + prev2;
            prev2 = prev1;
            prev1 = prev;
            prev = curr;
        }

        return prev;
    } */
}
