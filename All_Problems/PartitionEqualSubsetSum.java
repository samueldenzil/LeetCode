// https://www.codingninjas.com/codestudio/problems/partition-equal-subset-sum_892980
package All_Problems;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] arr = {3, 1, 1, 2, 2, 1};
        int n = arr.length;
        System.out.println(canPartition(arr, n));
    }

    public static boolean canPartition(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        if (sum % 2 == 1) {
            return false;
        }

        int k = sum / 2;

        boolean[] prev = new boolean[k + 1];

        // Base case
        prev[0] = true;
        if (arr[0] < k) {
            prev[arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            boolean[] curr = new boolean[k + 1];
            for (int target = 1; target < k + 1; target++) {
                boolean take = false;
                if (target >= arr[ind]) {
                    take = prev[target - arr[ind]];
                }
                boolean notTake = prev[target];

                curr[target] = take || notTake;
            }
            prev = curr;
        }

        return prev[k];
    }


    // Tabulation
    /* public static boolean canPartition(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        if (sum % 2 == 1) {
            return false;
        }

        int k = sum / 2;

        boolean[][] dp = new boolean[n][k + 1];

        // Base case
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] < k) {
            dp[0][arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target < k + 1; target++) {
                boolean take = false;
                if (target >= arr[ind]) {
                    take = dp[ind - 1][target - arr[ind]];
                }
                boolean notTake = dp[ind - 1][target];

                dp[ind][target] = take || notTake;
            }
        }

        return dp[n - 1][k];
    } */


    // Memoization
    /* public static boolean canPartition(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;

        int[][] dp = new int[n][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(n - 1, target, arr, dp);
    }

    private static boolean helper(int ind, int target, int[] arr, int[][] dp) {
        // Base case
        if (target == 0) {
            return true;
        }
        if (ind == 0) {
            return arr[0] == target;
        }

        if (dp[ind][target] != -1) {
            return dp[ind][target] == 1;
        }

        boolean take = false;
        if (arr[ind] < target) {
            take = helper(ind - 1, target - arr[ind], arr, dp);
        }
        boolean notTake = helper(ind - 1, target, arr, dp);

        boolean result = take || notTake;
        dp[ind][target] = result ? 1 : 0;

        return result;
    } */
}
