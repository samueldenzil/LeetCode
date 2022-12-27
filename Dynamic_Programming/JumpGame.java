// https://leetcode.com/problems/jump-game/
package Dynamic_Programming;

import java.util.Arrays;

public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    // Memoization
    public static boolean canJump(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return helper(0, nums, n, dp);
    }

    private static boolean helper(int ind, int[] nums, int n, int[] dp) {
        // base case
        if (ind == n - 1) {
            return true;
        }

        if (dp[ind] != -1) {
            return dp[ind] == 1;
        }

        int allowedJumps = nums[ind];
        for (int i = allowedJumps; i >= 1; i--) {
            if (isValidJump(ind, i, n)) {
                boolean curr = helper(ind + i, nums, n, dp);
                if (curr) {
                    dp[ind] = 1;
                    return true;
                }
            }
        }

        dp[ind] = 0;
        return false;
    }


    // Tabulation
    /* public static boolean canJump(int[] nums) {
        int n = nums.length;

        boolean[] dp = new boolean[n];

        // base case
        dp[n - 1] = true;

        for (int ind = n - 2; ind >= 0; ind--) {
            int allowedJumps = nums[ind];

            boolean flag = false;

            for (int i = allowedJumps; i >= 1; i--) {
                if (isValidJump(ind, i, n)) {
                    boolean curr = dp[ind + i];
                    if (curr) {
                        flag = true;
                        break;
                    }
                }
            }

            dp[ind] = flag;
        }

        return dp[0];
    } */

    private static boolean isValidJump(int currIndex, int step, int n) {
        return currIndex + step < n;
    }
}
