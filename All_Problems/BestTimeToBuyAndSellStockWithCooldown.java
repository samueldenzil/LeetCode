// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
package All_Problems;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, true, prices, dp);
    }

    // TC: O(n * 2)
    // SC: O(n * 2) + O(n)
    private static int helper(int i, boolean buy, int[] prices, int[][] dp) {
        if (i >= prices.length) {
            return 0;
        }
        int j = buy ? 1 : 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // no transaction today
        int noTransaction = helper(i + 1, buy, prices, dp);

        int transaction = 0;
        if (buy) {
            // buying stocks
            transaction = -prices[i] + helper(i + 1, false, prices, dp);
        } else {
            // selling stocks
            transaction = prices[i] + helper(i + 2, true, prices, dp);
        }

        return dp[i][j] = Math.max(noTransaction, transaction);
    }
}
