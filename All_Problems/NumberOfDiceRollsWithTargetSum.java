// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
package All_Problems;

import java.util.Arrays;

public class NumberOfDiceRollsWithTargetSum {

    public static void main(String[] args) {
        int n = 30, k = 30, target = 500;
        System.out.println(numRollsToTarget(n, k, target));
    }

    private static int MOD = (int) 1e9 + 7;

    public static int numRollsToTarget(int n, int k, int target) {
        long[][] dp = new long[n][target + 1];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return (int) helper(n - 1, k, target, dp);
    }

    private static long helper(int ind, int k, int target, long[][] dp) {
        // base case
        if (ind == 0) {
            for (int i = 1; i <= k; i++) {
                if (target - i == 0) {
                    return 1;
                }
            }
            return 0;
        }

        if (dp[ind][target] != -1) {
            return dp[ind][target];
        }

        long count = 0;
        for (int i = 1; i <= k; i++) {
            if (i <= target) {
                count += helper(ind - 1, k, target - i, dp) % MOD;
            }
        }

        return dp[ind][target] = count % MOD;
    }
}
