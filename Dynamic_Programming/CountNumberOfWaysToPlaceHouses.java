// https://leetcode.com/problems/count-number-of-ways-to-place-houses/
package Dynamic_Programming;

import java.util.Arrays;

public class CountNumberOfWaysToPlaceHouses {

    public static void main(String[] args) {
        int n = 30;
        System.out.println(countHousePlacements(n));
    }

    private static int MOD = (int) 1e9 + 7;

    // Tabulation + Space Optimization
    public static int countHousePlacements(int n) {
        // base case
        int prev2 = 1;
        int prev = 2;

        for (int ind = 2; ind < n + 1; ind++) {
            int take = prev2;
            int notTake = prev;

            int curr = (int) ((take + notTake) % MOD);

            prev2 = prev;
            prev = curr;
        }

        long ans = prev;
        return (int) ((ans * ans) % MOD);
    }


    // Tabulation
    /* public static int countHousePlacements(int n) {
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 1;
        dp[1] = 2;

        for (int ind = 2; ind < n + 1; ind++) {
            int take = dp[ind - 2];
            int notTake = dp[ind - 1];

            dp[ind] = (int) ((take + notTake) % MOD);
        }

        long ans = dp[n];
        return (int) ((ans * ans) % MOD);
    } */


    // Memoization
    /* public static int countHousePlacements(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        long ans = helper(n, dp);
        return (int) ((ans * ans) % MOD);
    }

    private static long helper(int ind, int[] dp) {
        // base case
        if (ind == 1) {
            return 2;   // if we have only one plot we have two options to take or not take
        }
        if (ind == 0) {
            return 1;
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        int take = (int) helper(ind - 2, dp);
        int notTake = (int) helper(ind - 1, dp);

        return dp[ind] = (take + notTake) % MOD;
    } */
}
