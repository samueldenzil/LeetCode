// https://leetcode.com/problems/rearrange-array-to-maximize-prefix-score/
package Greedy;

import java.util.Arrays;

public class RearrangeArrayToMaximizePrefixScore {

    public static void main(String[] args) {
        int[] nums = {2, -1, 0, 1, -3, 3, -3};
        System.out.println(maxScore(nums));
    }

    public static int maxScore(int[] nums) {
        int n = nums.length - 1;
        Arrays.sort(nums);

        long sum = 0;
        int count = 0;
        for (int i = n; i >= 0; i--) {
            sum += nums[i];
            if (sum > 0) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}
