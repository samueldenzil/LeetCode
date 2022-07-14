// https://leetcode.com/problems/coin-change-2/
package Dynamic_Programming;

import java.util.Arrays;

public class CoinChange2 {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};

        System.out.println(change(amount, coins));
    }

    // TC: O(n * amount)
    // SC: O(2 * amount)
    public static int change(int amount, int[] coins) {
        int n = coins.length;

        int[] prev = new int[amount + 1];

        // base case
        for (int T = 0; T <= amount; T++) {
            if (T % coins[0] == 0) {
                prev[T] = 1;
            } else {
                prev[T] = 0;
            }
        }

        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[amount + 1];
            for (int T = 0; T <= amount; T++) {
                int notTake = prev[T];

                int take = 0;
                if (coins[ind] <= T) {
                    take = curr[T - coins[ind]];
                }

                curr[T] = take + notTake;
            }
            prev = curr;
        }

        return prev[amount];
    }


    // TC: O(n * amount)
    // SC: O(n * amount)
    /* public static int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        // base case
        for (int T = 0; T <= amount; T++) {
            if (T % coins[0] == 0) {
                dp[0][T] = 1;
            } else {
                dp[0][T] = 0;
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int T = 0; T <= amount; T++) {
                int notTake = dp[ind - 1][T];

                int take = 0;
                if (coins[ind] <= T) {
                    take = dp[ind][T - coins[ind]];
                }

                dp[ind][T] = take + notTake;
            }
        }

        return dp[n - 1][amount];
    } */


    // TC: O(n * amount)
    // SC: O(n * amount) + O(target)
    /* public static int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(n - 1, amount, coins, dp);
    }

    private static int helper(int ind, int T, int[] coins, int[][] dp) {
        // base case
        if (ind == 0) {
            if (T % coins[0] == 0) {
                return 1;
            }
            return 0;
        }

        if (dp[ind][T] != -1) {
            return dp[ind][T];
        }

        int notTake = helper(ind - 1, T, coins, dp);
        int take = 0;
        if (coins[ind] <= T) {
            take = helper(ind, T - coins[ind], coins, dp);
        }

        return dp[ind][T] = take + notTake;
    } */
}
