// https://www.codingninjas.com/codestudio/problems/partitions-with-given-difference_3751628
package Dynamic_Programming;

import java.util.Arrays;

public class PartitionsWithGivenDifference {

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 4};
        int n = arr.length;
        int d = 3;

        System.out.println(countPartitions(n, d, arr));
    }

    private static int MOD = (int) 1e9 + 7;

    // Tabulation + Space Optimization
    public static int countPartitions(int n, int d, int[] arr) {
        int totalSum = 0;
        for (int e : arr) {
            totalSum += e;
        }

        // Edge case
        if (totalSum - d < 0 || (totalSum - d) % 2 == 1) {
            return 0;
        }
        int k = (totalSum - d) / 2;

        int[] prev = new int[k + 1];

        // Base case
        if (arr[0] == 0) {
            prev[0] = 2;
        } else {
            prev[0] = 1;
        }

        if (arr[0] != 0 && arr[0] <= k) {
            prev[arr[0]] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[k + 1];
            for (int sum = 0; sum < k + 1; sum++) {
                int notPick = prev[sum];
                int pick = 0;
                if (arr[ind] <= sum) {
                    pick = prev[sum - arr[ind]];
                }
                curr[sum] = (pick + notPick) % MOD;
            }
            prev = curr;
        }

        return prev[k];
    }


    // Tabulation
    /* public static int countPartitions(int n, int d, int[] arr) {
        int totalSum = 0;
        for (int e : arr) {
            totalSum += e;
        }

        // Edge case
        if (totalSum - d < 0 || (totalSum - d) % 2 == 1) {
            return 0;
        }
        int k = (totalSum - d) / 2;

        int[][] dp = new int[n][k + 1];

        // Base case
        if (arr[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
        }

        if (arr[0] != 0 && arr[0] <= k) {
            dp[0][arr[0]] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target < k + 1; target++) {
                int notPick = dp[ind - 1][target];
                int pick = 0;
                if (arr[ind] <= target) {
                    pick = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = (pick + notPick) % MOD;
            }
        }

        return dp[n - 1][k];
    } */

    // Memoization
    /* public static int countPartitions(int n, int d, int[] arr) {
        int totalSum = 0;
        for (int e : arr) {
            totalSum += e;
        }

        // Edge case
        if (totalSum - d < 0 || (totalSum - d) % 2 == 1) {
            return 0;
        }
        int target = (totalSum - d) / 2;

        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(n - 1, target, arr, dp);
    }

    private static int helper(int ind, int sum, int[] arr, int[][] dp) {
        // Base case
        if (ind == 0) {
            if (sum == 0 && arr[0] == 0) {
                return 2;
            }
            if (sum == 0 || sum == arr[0]) {
                return 1;
            }
            return 0;
        }

        if (dp[ind][sum] != -1) {
            return dp[ind][sum];
        }

        int notPick = helper(ind - 1, sum, arr, dp);
        int pick = 0;
        if (arr[ind] <= sum) {
            pick = helper(ind - 1, sum - arr[ind], arr, dp);
        }

        return dp[ind][sum] = (pick + notPick) % MOD;
    } */
}
