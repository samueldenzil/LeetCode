// https://leetcode.com/problems/arithmetic-slices/
package All_Problems;

public class ArithmeticSlices {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    // Time: O(n) Space: O(1)
    public static int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int count = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                count++;
            } else {
                ans += (count * (count + 1)) / 2;
                count = 0;
            }
        }

        if (count != 0) ans += (count * (count + 1)) / 2;

        return ans;
    }

    // Time: O(n) Space: O(1)
    /*
    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int ans = 0;
        int dp = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp++;
                ans += dp;
            } else {
                dp = 0;
            }
        }
        return ans;
    } */

    // Time: O(n) Space: O(n)
    /*
    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int ans = 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < nums.length; i++) {
            if ((nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2])) {
                dp[i] = dp[i - 1] + 1;
                ans += dp[i];
            }
        }
        return ans;
    } */
}