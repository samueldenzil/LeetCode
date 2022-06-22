// https://leetcode.com/problems/delete-and-earn/
package Dynamic_Programming;

public class DeleteAndEarn {

    public static void main(String[] args) {
        int[] nums = {3, 4, 2};
        System.out.println(deleteAndEarn(nums));
    }

    // TC: O(n) + O(n)
    // SC: O(1)
    public static int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] points = new int[n];

        int lastIndex = -1;

        for (int num : nums) {
            points[num]++;
            lastIndex = Math.max(lastIndex, num);
        }

        // base case
        int prev = points[0];
        int prev2 = 0;

        for (int ind = 1; ind < lastIndex + 1; ind++) {
            int take = points[ind] * ind;
            if (ind - 2 >= 0) {
                take += prev2;
            }
            int notTake = 0 + prev;

            int curr = Math.max(take, notTake);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    
    // TC: O(n) + O(n)
    // SC: O(n)
    /* public static int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] points = new int[n];

        int lastIndex = -1;

        for (int num : nums) {
            points[num]++;
            lastIndex = Math.max(lastIndex, num);
        }

        int[] dp = new int[lastIndex + 1];

        // base case
        dp[0] = points[0];

        for (int ind = 1; ind < lastIndex + 1; ind++) {
            int take = points[ind] * ind;
            if (ind - 2 >= 0) {
                take += dp[ind - 2];
            }
            int notTake = 0 + dp[ind - 1];

            dp[ind] = Math.max(take, notTake);
        }

        return dp[lastIndex];
    } */


    // TC: O(n) + O(n)
    // SC: O(n) + O(n)
    /* public static int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] points = new int[n];

        int lastIndex = -1;

        for (int num : nums) {
            points[num]++;
            lastIndex = Math.max(lastIndex, num);
        }

        int[] dp = new int[lastIndex + 1];
        Arrays.fill(dp, -1);

        return helper(lastIndex, points, dp);
    }

    private static int helper(int ind, int[] points, int[] dp) {
        if (ind == 0) {
            return points[0];
        }
        if (ind < 0) {
            return 0;
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        int take = (points[ind] * ind) + helper(ind - 2, points, dp);
        int notTake = 0 + helper(ind - 1, points, dp);

        return dp[ind] = Math.max(take, notTake);
    } */
}
