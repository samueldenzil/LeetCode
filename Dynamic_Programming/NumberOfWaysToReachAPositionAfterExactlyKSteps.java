// https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/
package Dynamic_Programming;

import java.util.Arrays;

public class NumberOfWaysToReachAPositionAfterExactlyKSteps {

    public static void main(String[] args) {
        int startPos = 1, endPos = 2, k = 3;
        System.out.println(numberOfWays(startPos, endPos, k));
    }

    private static int MOD = (int) 1e9 + 7;

    public static int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[3002][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(startPos, k, endPos, dp);
    }

    private static int helper(int curr, int k, int endPos, int[][] dp) {
        if (k == 0) {
            return curr == endPos ? 1 : 0;
        }

        if (dp[curr + 1001][k] != -1) {
            return dp[curr + 1001][k];
        }

        int leftMove = helper(curr - 1, k - 1, endPos, dp);
        int rightMove = helper(curr + 1, k - 1, endPos, dp);
        return dp[curr + 1001][k] = (leftMove + rightMove) % MOD;
    }
}
