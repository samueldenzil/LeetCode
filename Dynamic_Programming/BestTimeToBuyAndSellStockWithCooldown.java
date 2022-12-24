// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
package Dynamic_Programming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, true, prices, dp);
    }

    // Memoization
    // TC: O(n * 2)
    // SC: O(n * 2) + O(n)
    private static int helper(int day, boolean buy, int[] prices, int[][] dp) {
        // base case
        if (day >= prices.length) {
            return 0;
        }
        int j = buy ? 1 : 0;
        if (dp[day][j] != -1) {
            return dp[day][j];
        }

        int profit = 0;
        if (buy) {  // buy
            int take = helper(day + 1, false, prices, dp) - prices[day];
            int notTake = helper(day + 1, true, prices, dp);
            profit = Math.max(take, notTake);
        } else {    // sell
            int sell = prices[day] + helper(day + 2, true, prices, dp);
            int notSell = helper(day + 1, false, prices, dp);
            profit = Math.max(sell, notSell);
        }
        return dp[day][j] = profit;
    }


    // Tabulation
    // TC: O(n * 2)
    // SC: O(n * 2)
    /* public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];

        for (int day = n - 1; day >= 0; day--) {
            for (int j = 0; j <= 1; j++) {
                int profit = 0;
                if (j == 1) {  // buy
                    int take = dp[day + 1][0] - prices[day];
                    int notTake = dp[day + 1][1];
                    profit = Math.max(take, notTake);
                } else {    // sell
                    int sell = prices[day] + dp[day + 2][1];
                    int notSell = dp[day + 1][0];
                    profit = Math.max(sell, notSell);
                }
                dp[day][j] = profit;
            }
        }

        return dp[0][1];
    } */


    // Tabulation + Space Optimization
    // TC: O(n * 2)
    // SC: O(2 * 3) ~ O(1)
    /* public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] front1 = new int[2];
        int[] front2 = new int[2];

        for (int day = n - 1; day >= 0; day--) {
            int[] curr = new int[2];
            for (int j = 0; j <= 1; j++) {
                int profit = 0;
                if (j == 1) {  // buy
                    int take = front1[0] - prices[day];
                    int notTake = front1[1];
                    profit = Math.max(take, notTake);
                } else {    // sell
                    int sell = prices[day] + front2[1];
                    int notSell = front1[0];
                    profit = Math.max(sell, notSell);
                }
                curr[j] = profit;
            }
            front2 = front1;
            front1 = curr;
        }

        return front1[1];
    } */
}
