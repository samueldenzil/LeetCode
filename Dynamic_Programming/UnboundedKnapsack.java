// https://www.codingninjas.com/codestudio/problems/unbounded-knapsack_1215029
package Dynamic_Programming;

import java.util.Arrays;

public class UnboundedKnapsack {

    public static void main(String[] args) {
        int[] profit = {7, 2, 4};
        int[] weight = {5, 10, 20};
        int n = profit.length;
        int w = 15;

        System.out.println(unboundedKnapsack(n, w, profit, weight));
    }

    // Tabulation + Space Optimization
    // TC: O(n * w)
    // SC: O(w + 1)
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[] prev = new int[w + 1];

        // base case
        for (int W = 0; W < w + 1; W++) {
            int noOfItems = W / weight[0];
            prev[W] = profit[0] * noOfItems;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int W = 0; W < w + 1; W++) {
                int notTake = 0 + prev[W];
                int take = Integer.MIN_VALUE;
                if (weight[ind] <= W) {
                    take = profit[ind] + prev[W - weight[ind]];
                }

                prev[W] = Math.max(take, notTake);
            }
        }

        return prev[w];
    }


    // Tabulation + Space Optimization
    // TC: O(n * w)
    // SC: O(2 * (w + 1))
    /* public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[] prev = new int[w + 1];

        // base case
        for (int W = 0; W < w + 1; W++) {
            int noOfItems = W / weight[0];
            prev[W] = profit[0] * noOfItems;
        }

        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[w + 1];
            for (int W = 0; W < w + 1; W++) {
                int notTake = 0 + prev[W];
                int take = Integer.MIN_VALUE;
                if (weight[ind] <= W) {
                    take = profit[ind] + curr[W - weight[ind]];
                }

                curr[W] = Math.max(take, notTake);
            }
            prev = curr;
        }

        return prev[w];
    } */


    // Tabulation
    // TC: O(n * w)
    // SC: O(n * w)
    /* public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w + 1];

        // base case
        for (int W = 0; W < w + 1; W++) {
            int noOfItems = W / weight[0];
            dp[0][W] = profit[0] * noOfItems;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int W = 0; W < w + 1; W++) {
                int notTake = 0 + dp[ind - 1][W];
                int take = Integer.MIN_VALUE;
                if (weight[ind] <= W) {
                    take = profit[ind] + dp[ind][W - weight[ind]];
                }

                dp[ind][W] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][w];
    } */


    // Memoization
    // TC: O(n * w)
    // SC: O(n * w) + O(w)
    /* public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(n - 1, w, profit, weight, dp);
    }

    private static int helper(int ind, int W, int[] profit, int[] weight, int[][] dp) {
        // Base case
        if (ind == 0) {
            int noOfItems = W / weight[0];
            return profit[0] * noOfItems;
        }

        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }

        int notTake = 0 + helper(ind - 1, W, profit, weight, dp);
        int take = Integer.MIN_VALUE;
        if (weight[ind] <= W) {
            take = profit[ind] + helper(ind, W - weight[ind], profit, weight, dp);
        }

        return dp[ind][W] = Math.max(take, notTake);
    } */
}
