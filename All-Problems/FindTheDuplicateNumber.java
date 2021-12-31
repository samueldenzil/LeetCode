// Microsoft Interview Question
// https://leetcode.com/problems/find-the-duplicate-number/

class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int i = 0;
        
        while (i < nums.length) {            
            int correct = nums[i] - 1;
            
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        
        for (i = 0; i < nums.length; i++) {
            
            if (nums[i] - 1 != i) {
                return nums[i];
            }
        }
        return nums.length;
    }
    
    public void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}