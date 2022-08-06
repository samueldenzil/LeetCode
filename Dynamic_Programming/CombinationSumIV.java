// https://leetcode.com/problems/combination-sum-iv/
package Dynamic_Programming;

import java.util.Arrays;

public class CombinationSumIV {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        int target = 10;

        System.out.println(combinationSum4(nums, target));
    }

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];

        // base case
        dp[0] = 1;

        for (int T = 1; T <= target; T++) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= T) {
                    count += dp[T - nums[i]];
                }
            }
            dp[T] = count;
        }

        return dp[target];
    }


    /* public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);

        return helper(target, nums, dp);
    }

    private static int helper(int T, int[] nums, int[] dp) {
        if (T == 0) {
            return 1;
        }

        if (dp[T] != -1) {
            return dp[T];
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= T) {
                count += helper(T - nums[i], nums, dp);
            }
        }

        return dp[T] = count;
    } */
}
