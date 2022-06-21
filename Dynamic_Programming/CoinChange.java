// https://leetcode.com/problems/coin-change/
package Dynamic_Programming;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    // Tabulation + Space Optimization
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];

        // base case
        for (int T = 0; T < amount + 1; T++) {
            if (T % coins[0] == 0) {
                prev[T] = T / coins[0];
            } else {
                prev[T] = (int) 1e9;
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int T = 0; T < amount + 1; T++) {
                int notTake = 0 + prev[T];

                int take = Integer.MAX_VALUE;
                if (coins[ind] <= T) {
                    take = 1 + curr[T - coins[ind]];
                }

                curr[T] = Math.min(take, notTake);
            }
            prev = curr;
        }

        int ans = prev[amount];

        if (ans >= 1e9) {
            return -1;
        }
        return ans;
    }


    // Tabulation
    /* public static int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        // base case
        for (int T = 0; T < amount + 1; T++) {
            if (T % coins[0] == 0) {
                dp[0][T] = T / coins[0];
            } else {
                dp[0][T] = (int) 1e9;
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int T = 0; T < amount + 1; T++) {
                int notTake = 0 + dp[ind - 1][T];

                int take = Integer.MAX_VALUE;
                if (coins[ind] <= T) {
                    take = 1 + dp[ind][T - coins[ind]];
                }

                dp[ind][T] = Math.min(take, notTake);
            }
        }

        int ans = dp[n - 1][amount];

        if (ans >= 1e9) {
            return -1;
        }
        return ans;
    } */


    // Memoization
    /* public static int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = helper(n - 1, amount, coins, dp);

        if (ans >= 1e9) {
            return -1;
        }
        return ans;
    }

    private static int helper(int ind, int T, int[] coins, int[][] dp) {
        // base case
        if (ind == 0) {
            if (T % coins[0] == 0) {
                return T / coins[0];
            } else {
                return (int) 1e9;
            }
        }

        if (dp[ind][T] != -1) {
            return dp[ind][T];
        }

        int notTake = 0 + helper(ind - 1, T, coins, dp);

        int take = Integer.MAX_VALUE;
        if (coins[ind] <= T) {
            take = 1 + helper(ind, T - coins[ind], coins, dp);
        }

        return dp[ind][T] = Math.min(take, notTake);
    } */
}
