// Amazon Interview Question
// https://leetcode.com/problems/missing-number

class MissingNumber {
    public int missingNumber(int[] nums) {
        int i = 0;
        int n = nums.length;
        
        while (i < n) {
            if (nums[i] != i && nums[i] != n) {
                swap(nums, nums[i], i);
            } else {
                i++;
            }
        }
        
        for (i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return i;
    }
    
    public void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}