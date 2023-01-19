// https://leetcode.com/problems/maximum-sum-circular-subarray/
package Arrays;

public class MaximumSumCircularSubarray {

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -2};
        System.out.println(maxSubarraySumCircular(nums));
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        for (int it : nums) {
            totalSum += it;
        }

        int minSum = kadanesAlgoMinSum(nums);
        int maxSum = kadanesAlgoMaxSum(nums);   // case 1 - ans in the middle

        int circularSum = totalSum - minSum;    // case 2 - ans in the circular

        if (maxSum > 0) {
            return Math.max(maxSum, circularSum);
        }
        return maxSum;
    }

    private static int kadanesAlgoMaxSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    private static int kadanesAlgoMinSum(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, sum);
            if (sum > 0) {
                sum = 0;
            }
        }
        return min;
    }
}
