// https://leetcode.com/problems/count-subarrays-with-fixed-bounds/
package Arrays;

public class CountSubarraysWithFixedBounds {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 7, 5};
        int minK = 1;
        int maxK = 5;
        System.out.println(countSubarrays(nums, minK, maxK));
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long ans = 0;
        int minPos = -1;
        int maxPos = -1;
        int culpritIdx = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                culpritIdx = i;
            }

            if (nums[i] == minK) {
                minPos = i;
            }

            if (nums[i] == maxK) {
                maxPos = i;
            }

            int smaller = Math.min(minPos, maxPos);
            int temp = smaller - culpritIdx;
            ans += Math.max(temp, 0);
        }

        return ans;
    }
}
