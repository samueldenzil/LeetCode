// https://leetcode.com/problems/house-robber-ii/
package Dynamic_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class HouseRobberII {

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println(rob(nums));
    }

    // Tabulation + Space Optimization
    public static int rob(int[] nums) {
        int n = nums.length;
        /*  I am pretty sure that my answer cannot contain first and last element together,
            so lets check taking all the houses except the last house and then check taking
            all the house except the first house, and then we will return the max out of these two */

        if (n == 1) {
            return nums[0];
        }

        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i != n - 1) {
                temp1.add(nums[i]);
            }
            if (i != 0) {
                temp2.add(nums[i]);
            }
        }

        int ans1 = helper(temp1.size() - 1, temp1);

        int ans2 = helper(temp2.size() - 1, temp2);

        return Math.max(ans1, ans2);
    }

    private static int helper(int ind, List<Integer> nums) {
        int n = nums.size();

        int prev = nums.get(0);
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int pick = nums.get(i) + prev2;
            int notPick = 0 + prev;

            int currI = Math.max(pick, notPick);

            prev2 = prev;
            prev = currI;
        }

        return prev;
    }


    // Tabulation
    /* public static int rob(int[] nums) {
        int n = nums.length;
        // I am pretty sure that my answer cannot contain first and last element together,
        // so lets check taking all the houses except the last house and then check taking
        // all the house except the first house, and then we will return the max out of these two

        if (n == 1) {
            return nums[0];
        }

        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i != n - 1) {
                temp1.add(nums[i]);
            }
            if (i != 0) {
                temp2.add(nums[i]);
            }
        }

        int ans1 = helper(temp1.size() - 1, temp1);

        int ans2 = helper(temp2.size() - 1, temp2);

        return Math.max(ans1, ans2);
    }

    private static int helper(int ind, List<Integer> nums) {
        int n = nums.size();

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        dp[0] = nums.get(0);

        for (int i = 1; i < n; i++) {
            int pick = nums.get(i);
            if (i > 1) {
                pick += dp[i - 2];
            }
            int notPick = 0 + dp[i - 1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    } */


    // Memoization
    /* public static int rob(int[] nums) {
        int n = nums.length;
        // I am pretty sure that my answer cannot contain first and last element together,
        // so lets check taking all the houses except the last house and then check taking
        // all the house except the first house, and then we will return the max out of these two

        if (n == 1) {
            return nums[0];
        }

        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i != n - 1) {
                temp1.add(nums[i]);
            }
            if (i != 0) {
                temp2.add(nums[i]);
            }
        }

        int[] dp = new int[n - 1];

        Arrays.fill(dp, -1);
        int ans1 = helper(temp1.size() - 1, temp1, dp);

        Arrays.fill(dp, -1);
        int ans2 = helper(temp2.size() - 1, temp2, dp);

        return Math.max(ans1, ans2);
    }

    private static int helper(int ind, List<Integer> nums, int[] dp) {
        // Base case
        if (ind == 0) {
            return nums.get(ind);
        }
        if (ind < 0) {
            return 0;
        }
        if (dp[ind] != -1) {
            return dp[ind];
        }

        int pick = nums.get(ind) + helper(ind - 2, nums, dp);
        int notPick = 0 + helper(ind - 1, nums, dp);

        return dp[ind] = Math.max(pick, notPick);
    } */
}
