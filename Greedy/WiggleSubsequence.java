// https://leetcode.com/problems/wiggle-subsequence/
package Greedy;

public class WiggleSubsequence {

    public static void main(String[] args) {
        int[] nums = {1, 7, 4, 9, 2, 5};
        System.out.println(wiggleMaxLength(nums));
    }

    public static int wiggleMaxLength(int[] nums) {
        int n = nums.length;

        // edge case
        if (n <= 1) {
            return n;
        }

        int up = 1;
        int down = 1;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {    // uphill case
                up = down + 1;
            } else if (nums[i] > nums[i + 1]) { // downhill case
                down = up + 1;
            }
        }

        return Math.max(up, down);
    }
}
