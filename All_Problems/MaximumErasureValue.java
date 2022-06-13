// https://leetcode.com/problems/maximum-erasure-value/
package All_Problems;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {

    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 5, 6};
        System.out.println(maximumUniqueSubarray(nums));
    }

    public static int maximumUniqueSubarray(int[] nums) {
        int maxSum = 0;
        int currSum = 0;

        int i = 0;
        int j = 0;
        Set<Integer> set = new HashSet<>();

        while (i < nums.length && j < nums.length) {
            currSum += nums[j];

            while (i <= j && set.contains(nums[j])) {
                currSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }

            set.add(nums[j]);
            j++;
            maxSum = Math.max(maxSum, currSum);
        }


        return maxSum;
    }
}
