// https://leetcode.com/problems/number-of-ways-to-earn-points/
package All_Problems;

import java.util.Arrays;

public class NumberOfWaysToEarnPoints {

    public static void main(String[] args) {
        int target = 6;
        int[][] types = {{6, 1}, {3, 2}, {2, 3}};
        System.out.println(waysToReachTarget(target, types));
    }

    private static int MOD = (int) 1e9 + 7;

    // Memoization
    public static int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        long[][] dp = new long[n + 1][target + 1];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        return (int) helper(0, target, types, dp) % MOD;
    }

    private static long helper(int idx, int T, int[][] types, long[][] dp) {
        // base case
        if (idx == types.length) {
            return T == 0 ? 1 : 0;
        }
        if (T == 0) {
            return 1;
        }

        if (dp[idx][T] != -1) {
            return dp[idx][T];
        }

        long notTake = helper(idx + 1, T, types, dp) % MOD;

        long take = 0;
        for (int k = 1; k <= types[idx][0]; k++) {
            if (k * types[idx][1] <= T) {
                take += helper(idx + 1, T - (k * types[idx][1]), types, dp) % MOD;
            }
        }

        return dp[idx][T] = (take + notTake) % MOD;
    }


    // Tabulation
    /* public static int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        long[][] dp = new long[n + 1][target + 1];

        // base case
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int T = 1; T <= target; T++) {
                long notTake = dp[idx + 1][T] % MOD;

                long take = 0;
                for (int k = 1; k <= types[idx][0]; k++) {
                    if (k * types[idx][1] <= T) {
                        take += dp[idx + 1][T - (k * types[idx][1])] % MOD;
                    }
                }

                dp[idx][T] = (take + notTake) % MOD;
            }
        }

        return (int) dp[0][target] % MOD;
    } */


    // Tabulation + Space Optimization
    /* public static int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        long[] front = new long[target + 1];

        // base case
        front[0] = 1;

        for (int idx = n - 1; idx >= 0; idx--) {
            long[] curr = new long[target + 1];
            curr[0] = 1;
            for (int T = 1; T <= target; T++) {
                long notTake = front[T] % MOD;

                long take = 0;
                for (int k = 1; k <= types[idx][0]; k++) {
                    if (k * types[idx][1] <= T) {
                        take += front[T - (k * types[idx][1])] % MOD;
                    }
                }

                curr[T] = (take + notTake) % MOD;
            }
            front = curr;
        }

        return (int) front[target] % MOD;
    } */
}
