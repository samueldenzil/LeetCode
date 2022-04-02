// https://leetcode.com/problems/find-triangular-sum-of-an-array/
package All_Problems;

public class FindTriangularSumOfAnArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(triangularSum(nums));
    }

    public static int triangularSum(int[] nums) {
        for (int n = 0; n < nums.length - 1; n++) {

            for (int i = 0; i < nums.length - 1 - n; i++) {
                nums[i] += nums[i + 1];
                nums[i] = nums[i] % 10;
            }
        }

        return nums[0];
    }
}
