// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
package All_Problems;

public class MinimumOperationsToReduceXToZero {

    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;

        System.out.println(minOperations(nums, x));
    }

    public static int minOperations(int[] nums, int x) {
        int i = 0;
        int j = 0;

        int totalSum = 0;

        for (int n : nums) {
            totalSum += n;
        }
        int targetSum = totalSum - x;

        int max = -1;
        int sum = 0;

        while (i < nums.length && j < nums.length) {
            sum += nums[j];

            while (i <= j && sum > targetSum) {
                sum -= nums[i];
                i++;
            }

            if (sum == targetSum) {
                max = Math.max(max, j - i + 1);
            }
            j++;
        }

        return nums.length - max;
    }
}
