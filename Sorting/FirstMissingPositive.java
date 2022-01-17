package Sorting;
// Amazon Interview Question
// https://leetcode.com/problems/first-missing-positive/

class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        
        while (i < nums.length) {
            int correct = nums[i] - 1;
            
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return nums.length + 1;
    }
    
    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}