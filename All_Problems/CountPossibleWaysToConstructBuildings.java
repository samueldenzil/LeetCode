// https://practice.geeksforgeeks.org/problems/count-possible-ways-to-construct-buildings5007/1
package All_Problems;

import java.util.Arrays;

public class CountPossibleWaysToConstructBuildings {

    public static void main(String[] args) {
        int N = 3;
        System.out.println(TotalWays(N));
    }

    static int MOD = (int) (1e9 + 7);

    // TC: O(n * 2)
    // SC: O(2 * 2)
    public static int TotalWays(int N) {
        // Code here
        long[] prev = new long[2];

        // base case
        prev[0] = 1;
        prev[1] = 1;

        for (int ind = 1; ind <= N; ind++) {
            long[] curr = new long[2];
            for (int prevPlot = 0; prevPlot <= 1; prevPlot++) {
                if (prevPlot == 1) {
                    // if we have already built the building we cannot use this place now
                    curr[prevPlot] = (int) (prev[0] % MOD);
                    continue;
                }

                // if the prev plot is empty then we have to option to build the building or leave the place
                int take = (int) prev[1];
                int notTake = (int) prev[0];

                curr[prevPlot] = (take + notTake) % MOD;
            }
            prev = curr;
        }

        long ans = prev[0];
        return (int) ((ans * ans) % MOD);
    }


    // TC: O(n * 2)
    // SC: O(n * 2)
    /* public static int TotalWays(int N) {
        // Code here
        long[][] dp = new long[N + 1][2];

        // base case
        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int ind = 1; ind <= N; ind++) {
            for (int prevPlot = 0; prevPlot <= 1; prevPlot++) {
                if (prevPlot == 1) {
                    // if we have already built the building we cannot use this place now
                    dp[ind][prevPlot] = (int) (dp[ind - 1][0] % MOD);
                    continue;
                }

                // if the prev plot is empty then we have to option to build the building or leave the place
                int take = (int) dp[ind - 1][1];
                int notTake = (int) dp[ind - 1][0];

                dp[ind][prevPlot] = (take + notTake) % MOD;
            }
        }

        long ans = dp[N][0];
        return (int) ((ans * ans) % MOD);
    } */


    // TC: O(N * 2)
    // SC: O(n * 2) + O(n)
    /* public static int TotalWays(int N) {
        // Code here
        int[][] dp = new int[N + 1][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        long ans = helper(N, 0, dp);
        return (int) ((ans * ans) % MOD);
    }

    private static long helper(int ind, int prevPlot, int[][] dp) {
        // base case
        if (ind == 0) {
            return 1;
        }

        if (dp[ind][prevPlot] != -1) {
            return dp[ind][prevPlot];
        }

        if (prevPlot == 1) {
            // if we have already built the building we cannot use this place now
            return dp[ind][prevPlot] = (int) helper(ind - 1, 0, dp);
        }

        // if the prev plot is empty then we have to option to build the building or leave the place
        int take = (int) helper(ind - 1, 1, dp);
        int notTake = (int) helper(ind - 1, 0, dp);

        return dp[ind][prevPlot] = (take + notTake) % MOD;
    } */
}
