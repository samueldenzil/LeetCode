// https://www.codingninjas.com/codestudio/problems/subset-sum-equal-to-k_1550954
package Dynamic_Programming;

public class SubsetSumEqualToK {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        int n = arr.length;
        int k = 5;
        System.out.println(subsetSumToK(n, k, arr));
    }

    // TC: O(n * k)
    // SC: O(k)
    public static boolean subsetSumToK(int n, int k, int[] arr) {
        boolean[] prev = new boolean[k + 1];

        // Base case
        prev[0] = true;
        if (arr[0] <= k)
            prev[arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            boolean[] curr = new boolean[k + 1];
            curr[0] = true;
            for (int target = 1; target < k + 1; target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if (target >= arr[ind]) {
                    take = prev[target - arr[ind]];
                }

                curr[target] = take || notTake;
            }
            prev = curr;
        }

        return prev[k];
    }


    // TC: O(n * k)
    // SC: O(n * k)
    /* public static boolean subsetSumToK(int n, int k, int[] arr) {
        boolean[][] dp = new boolean[n][k + 1];

        // Base case
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= k)
            dp[0][arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target < k + 1; target++) {
                boolean notTake = dp[ind - 1][target];
                boolean take = false;
                if (target >= arr[ind]) {
                    take = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = take || notTake;
            }
        }

        return dp[n - 1][k];
    } */


    // TC: O(n * k)
    // SC: O(n * k) + O(n)
    /* public static boolean subsetSumToK(int n, int k, int[] arr) {
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(n - 1, k, arr, dp);
    }

    private static boolean helper(int ind, int target, int[] arr, int[][] dp) {
        // Base case
        if (target == 0) {
            return true;
        }
        if (ind == 0) {
            return arr[ind] == target;
        }

        if (dp[ind][target] != -1) {
            return dp[ind][target] == 1;
        }

        boolean notTake = helper(ind - 1, target, arr, dp);
        boolean take = false;
        if (target >= arr[ind]) {
            take = helper(ind - 1, target - arr[ind], arr, dp);
        }

        boolean result = take || notTake;
        dp[ind][target] = result ? 1 : 0;
        return result;
    } */
}
