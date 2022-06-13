// https://www.codingninjas.com/codestudio/problems/number-of-subsets_3952532
package Dynamic_Programming;

import java.util.Arrays;

public class NumberOfSubsets {

    public static void main(String[] args) {
        int[] num = {1, 2, 2, 3};
        int target = 3;
        System.out.println(findWays(num, target));
    }

    // Tabulation + Space Optimization
    public static int findWays(int[] num, int k) {
        int n = num.length;
        int[] prev = new int[k + 1];

        // Base case
        prev[0] = 1;
        if (num[0] <= k) {
            prev[num[0]] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[k + 1];
            curr[0] = 1;
            for (int target = 1; target < k + 1; target++) {
                int notPick = prev[target];
                int pick = 0;
                if (num[ind] <= target) {
                    pick = prev[target - num[ind]];
                }
                curr[target] = pick + notPick;
            }
            prev = curr;
        }

        return prev[k];
    }


    // Tabulation
    /* public static int findWays(int[] num, int k) {
        int n = num.length;
        int[][] dp = new int[n][k + 1];

        // Base case
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if (num[0] <= k) {
            dp[0][num[0]] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target < k + 1; target++) {
                int notPick = dp[ind - 1][target];
                int pick = 0;
                if (num[ind] <= target) {
                    pick = dp[ind - 1][target - num[ind]];
                }
                dp[ind][target] = pick + notPick;
            }
        }

        return dp[n - 1][k];
    } */


    // Memoization
    /* public static int findWays(int[] num, int target) {
        int n = num.length;
        int[][] dp = new int[n][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(n - 1, target, num, dp);
    }

    private static int helper(int ind, int target, int[] num, int[][] dp) {
        // Base case
        if (target == 0) {
            return 1;
        }
        if (ind == 0) {
            return num[ind] == target ? 1 : 0;
        }

        if (dp[ind][target] != -1) {
            return dp[ind][target];
        }

        int notPick = helper(ind - 1, target, num, dp);
        int pick = 0;
        if (num[ind] <= target) {
            pick = helper(ind - 1, target - num[ind], num, dp);
        }

        return dp[ind][target] = pick + notPick;
    } */
}
