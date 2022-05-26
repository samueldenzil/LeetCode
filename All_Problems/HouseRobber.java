// https://leetcode.com/problems/house-robber/
package All_Problems;

import java.util.Arrays;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }

    // TC: O(n)
    // SC: O(1)
    public static int rob(int[] nums) {
        int n = nums.length;

        // Base case
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int pick = nums[i] + prev2;
            int notPick = 0 + prev;

            int currI = Math.max(pick, notPick);
            prev2 = prev;
            prev = currI;
        }

        return prev;
    }


    // TC: O(n)
    // SC: O(n)
    /* public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        // Base Case
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1)
                pick += dp[i - 2];

            int notPick = 0 + dp[i - 1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    } */


    // TC: O(n)
    // SC: O(n) + O(n)
    /* public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(n - 1, nums, dp);
    }

    private static int helper(int ind, int[] nums, int[] dp) {
        // Base case
        if (ind == 0) {
            return nums[ind];
        }
        if (ind < 0) {
            return 0;
        }
        if (dp[ind] != -1) {
            return dp[ind];
        }

        int pick = nums[ind] + helper(ind - 2, nums, dp);
        int notPick = 0 + helper(ind - 1, nums, dp);

        return dp[ind] = Math.max(pick, notPick);
    } */
}
