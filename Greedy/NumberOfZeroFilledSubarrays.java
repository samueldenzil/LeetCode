// https://leetcode.com/problems/number-of-zero-filled-subarrays/
package Greedy;

public class NumberOfZeroFilledSubarrays {

    public static void main(String[] args) {
        int[] nums = {1, 3, 0, 0, 2, 0, 0, 4};
        System.out.println(zeroFilledSubarray(nums));
    }

    public static long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long ans = 0;
        long count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                ans += (count * (count + 1)) / 2;
                count = 0;
            }
        }
        if (count != 0) {
            ans += (count * (count + 1)) / 2;
        }

        return ans;
    }
}
