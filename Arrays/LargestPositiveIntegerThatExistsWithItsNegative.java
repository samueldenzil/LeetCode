// https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/
package Arrays;

public class LargestPositiveIntegerThatExistsWithItsNegative {

    public static void main(String[] args) {
        int[] nums = {-1, 2, -3, 3};
        System.out.println(findMaxK(nums));
    }

    public static int findMaxK(int[] nums) {
        int n = nums.length;
        int max = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && nums[i] == -nums[j]) {
                    max = Math.max(max, Math.abs(nums[i]));
                }
            }
        }

        return max;
    }
}
