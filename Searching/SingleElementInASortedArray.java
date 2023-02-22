// https://leetcode.com/problems/single-element-in-a-sorted-array/
package Searching;

public class SingleElementInASortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == nums[mid ^ 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[start];
    }
    // in order to check for the left half
    // 1st instance -> even index
    // 2nd instance -> odd index, i need to check on the left if the 1st instance of that number is there or not
}
