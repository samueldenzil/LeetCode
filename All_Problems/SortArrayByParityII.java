// https://leetcode.com/problems/sort-array-by-parity-ii/
package All_Problems;

import java.util.Arrays;

public class SortArrayByParityII {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 6, 5, 7, 8, 10};
        System.out.println(Arrays.toString(sortArrayByParityII(nums)));
    }

    // TC: O(n)
    // SC: O(1)
    public static int[] sortArrayByParityII(int[] nums) {
        // search for odd number at even index
        // search for even number at odd index

        int n = nums.length;

        int oddNoAtEvenIndex = 0;
        int evenNoAtOddIndex = 1;
        while (oddNoAtEvenIndex < n && evenNoAtOddIndex < n) {
            while (oddNoAtEvenIndex < n && nums[oddNoAtEvenIndex] % 2 == 0) {
                oddNoAtEvenIndex += 2;
            }
            while (evenNoAtOddIndex < n && nums[evenNoAtOddIndex] % 2 == 1) {
                evenNoAtOddIndex += 2;
            }
            if (oddNoAtEvenIndex < n && evenNoAtOddIndex < n) {
                swap(nums, oddNoAtEvenIndex, evenNoAtOddIndex);
            }
        }

        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
