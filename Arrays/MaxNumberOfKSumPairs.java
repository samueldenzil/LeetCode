// https://leetcode.com/problems/max-number-of-k-sum-pairs/
package Arrays;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 3};
        int k = 5;
        System.out.println(maxOperations(nums, k));
    }

    // TC: O(nlog(n)) SC: O(1)
    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;

        int count = 0;
        while (start < end) {
            if (nums[start] == k - nums[end]) { // nums[start] + nums[end] == k
                count++;
                start++;
                end--;
            } else if (nums[start] > k - nums[end]) {  // nums[start] + nums[end] > k
                end--;
            } else {
                start++;
            }
        }
        return count;
    }
}
