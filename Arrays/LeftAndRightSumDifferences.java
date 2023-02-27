// https://leetcode.com/problems/left-and-right-sum-differences/
package Arrays;

import java.util.Arrays;

public class LeftAndRightSumDifferences {

    public static void main(String[] args) {
        int[] nums = {10, 4, 8, 3};
        System.out.println(Arrays.toString(leftRigthDifference(nums)));
    }

    public static int[] leftRigthDifference(int[] nums) {
        int n = nums.length;

        int[] leftSum = new int[n];
        for (int i = 1; i < n; i++) {
            leftSum[i] += (leftSum[i - 1] + nums[i - 1]);
        }

        int[] rightSum = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] += (rightSum[i + 1] + nums[i + 1]);
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return answer;
    }
}
