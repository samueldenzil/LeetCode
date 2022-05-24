// https://leetcode.com/problems/climbing-stairs
package Dynamic_Programming;

import java.util.Arrays;

public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 45;
        System.out.println(climbStairs(n));
    }

    // TC: O(n)
    // SC: O(1)
    public static int climbStairs(int n) {
        int prev = 1;
        int prev2 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    // TC: O(n)
    // SC: O(n)
    /* public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    } */


    // TC: O(n)
    // SC: O(n) + O(n)
    /* public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return helper(n, dp);
    }

    private static int helper(int index, int[] dp) {
        if (index <= 1) {
            return 1;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        int left = helper(index - 1, dp);
        int right = helper(index - 2, dp);

        return dp[index] = left + right;
    } */
}
