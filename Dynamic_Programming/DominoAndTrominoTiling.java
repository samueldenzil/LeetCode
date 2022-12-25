// https://leetcode.com/problems/domino-and-tromino-tiling/
package Dynamic_Programming;

import java.util.Arrays;

public class DominoAndTrominoTiling {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(numTilings(n));
    }

    static int MOD = (int) 1e9 + 7;

    // Memoization
    // TC: O(n)
    // SC: O(n) + O(n)
    public static int numTilings(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp) % MOD;
    }

    private static int helper(int n, int[] dp) {
        // base case
        if (n == 1 || n == 2) {
            return n;
        }
        if (n == 3) {
            return 5;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = ((2 * helper(n - 1, dp)) % MOD + helper(n - 3, dp) % MOD) % MOD;
    }


    // Tabulation
    // TC: O(n)
    // SC: O(n)
    /* public static int numTilings(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for (int i = 4; i <= n; i++) {
            dp[i] = ((2 * dp[i - 1]) % MOD + dp[i - 3] % MOD) % MOD;
        }

        return dp[n] % MOD;
    } */
}
