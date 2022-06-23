// https://leetcode.com/problems/jump-game-ii/
package All_Problems;

public class JumpGameII {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        // base case
        dp[n - 1] = 0;

        for (int ind = n - 2; ind >= 0; ind--) {
            int allowedJumps = nums[ind];
            int min = (int) 1e9;

            for (int step = allowedJumps; step >= 1; step--) {
                int curr = 1;
                int nextStep = ind + step;
                if (nextStep < n) {
                    curr += dp[nextStep];
                }
                min = Math.min(min, curr);
            }

            dp[ind] = min;
        }

        return dp[0];
    }


    /* public static int jump(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return helper(0, nums, n, dp);
    }

    private static int helper(int ind, int[] nums, int n, int[] dp) {
        // base case
        if (ind == n - 1) {
            return 0;
        }
        if (ind >= n) {
            return 0;
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        int allowedJumps = nums[ind];
        int min = (int) 1e9;

        for (int step = allowedJumps; step >= 1; step--) {
            int curr = 1 + helper(ind + step, nums, n, dp);
            min = Math.min(min, curr);
        }

        return dp[ind] = min;
    } */
}
