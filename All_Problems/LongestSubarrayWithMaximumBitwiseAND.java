// https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/
package All_Problems;

public class LongestSubarrayWithMaximumBitwiseAND {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 2, 2};
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int maxElement = 0;
        for (int it : nums) {   // finding out the max element
            maxElement = Math.max(maxElement, it);
        }

        int count = 0;
        int ans = 1;

        for (int i = 0; i < nums.length; i++) { // finding continuous occurrence of the max element
            if (nums[i] == maxElement) {
                count++;
            } else {
                count = 0;
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
