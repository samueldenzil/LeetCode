// https://leetcode.com/problems/non-decreasing-array/
package All_Problems;

public class NonDecreasingArray {

    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 3};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        int n = nums.length;
        boolean changed = false;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] <= nums[i + 1]) {
                continue;
            }
            if (changed) {
                return false;
            }

            // We want to decrease the left element
            // i-1 i  i+1
            // [3, 4, 2]

            //  i  i+1
            // [4, 2]
            if (i == 0 || nums[i + 1] >= nums[i - 1]) {
                nums[i] = nums[i + 1];
            } else {
                nums[i + 1] = nums[i];
            }
            changed = true;
        }

        return true;
    }
}
