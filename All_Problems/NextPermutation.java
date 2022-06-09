// https://leetcode.com/problems/next-permutation/
package All_Problems;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        int ind1 = i;

        i = nums.length - 1;
        if (ind1 >= 0) {
            while (nums[i] <= nums[ind1]) {
                i--;
            }
            swap(nums, ind1, i);
        }
        rotate(nums, ind1 + 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void rotate(int[] arr, int start) {
        int i = start;
        int j = arr.length - 1;

        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
