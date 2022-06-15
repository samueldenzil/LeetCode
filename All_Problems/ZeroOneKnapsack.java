// https://www.codingninjas.com/codestudio/problems/0-1-knapsack_920542
package All_Problems;

import java.util.Arrays;

public class ZeroOneKnapsack {

    public static void main(String[] args) {
        int[] weight = {1, 2, 4, 5};
        int[] value = {5, 4, 8, 6};
        int n = weight.length;
        int maxWeight = 5;

        System.out.println(knapsack(weight, value, n, maxWeight));
    }

    // TC: O(n * maxWeight)
    // SC: O(maxWeight)
    public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev = new int[maxWeight + 1];

        // Base case
        for (int W = weight[0]; W < maxWeight + 1; W++) {
            prev[W] = value[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int W = maxWeight; W >= 0; W--) {
                int notTake = 0 + prev[W];
                int take = Integer.MIN_VALUE;
                if (weight[ind] <= W) {
                    take = value[ind] + prev[W - weight[ind]];
                }

                prev[W] = Math.max(take, notTake);
            }
        }

        return prev[maxWeight];
    }


    // TC: O(n * maxWeight)
    // SC: O(2 * maxWeight)
    /* public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev = new int[maxWeight + 1];

        // Base case
        for (int W = weight[0]; W < maxWeight + 1; W++) {
            prev[W] = value[0];
        }

        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[maxWeight + 1];
            for (int W = 0; W < maxWeight + 1; W++) {
                int notTake = 0 + prev[W];
                int take = Integer.MIN_VALUE;
                if (weight[ind] <= W) {
                    take = value[ind] + prev[W - weight[ind]];
                }

                curr[W] = Math.max(take, notTake);
            }
            prev = curr;
        }

        return prev[maxWeight];
    } */


    // TC: O(n * maxWeight)
    // SC: O(n * maxWeight)
    /* public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];

        // Base case
        for (int W = weight[0]; W < maxWeight + 1; W++) {
            dp[0][W] = value[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int W = 0; W < maxWeight + 1; W++) {
                int notTake = 0 + dp[ind - 1][W];
                int take = Integer.MIN_VALUE;
                if (weight[ind] <= W) {
                    take = value[ind] + dp[ind - 1][W - weight[ind]];
                }

                dp[ind][W] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][maxWeight];
    } */


    // TC: O(2^n)
    // SC: O(n) + O(n * maxWeight)
    /* public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(n - 1, maxWeight, weight, value, dp);
    }

    private static int helper(int ind, int W, int[] weight, int[] value, int[][] dp) {
        // Base case
        if (ind == 0) {
            if (weight[0] <= W) {
                return value[0];
            } else {
                return 0;
            }
        }

        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }

        int notTake = 0 + helper(ind - 1, W, weight, value, dp);
        int take = Integer.MIN_VALUE;
        if (weight[ind] <= W) {
            take = value[ind] + helper(ind - 1, W - weight[ind], weight, value, dp);
        }

        return dp[ind][W] = Math.max(take, notTake);
    } */
}
