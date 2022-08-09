// https://leetcode.com/problems/longest-increasing-subsequence/
package Dynamic_Programming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(0, -1, nums, dp);
    }

    private static int helper(int ind, int prev, int[] nums, int[][] dp) {
        // base case
        if (ind == nums.length) {
            return 0;
        }

        if (dp[ind][prev + 1] != -1) {
            return dp[ind][prev + 1];
        }

        int notTake = helper(ind + 1, prev, nums, dp);
        int take = 0;
        if (prev == -1 || nums[ind] > nums[prev]) {
            take = 1 + helper(ind + 1, ind, nums, dp);
        }

        return dp[ind][prev + 1] = Math.max(take, notTake);
    }
}
