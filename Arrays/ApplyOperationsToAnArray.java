// https://leetcode.com/problems/apply-operations-to-an-array/
package Arrays;

import java.util.Arrays;

public class ApplyOperationsToAnArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1, 1, 0};
        System.out.println(Arrays.toString(applyOperations(nums)));
    }

    public static int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // shifting all zeros
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
        while (i < n) {
            nums[i] = 0;
            i++;
        }

        return nums;
    }
}
