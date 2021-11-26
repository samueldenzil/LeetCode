// https://leetcode.com/problems/set-mismatch/

class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        
        int[] ans = new int[2];
        for (i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                ans[0] = nums[i];
                ans[1] = i + 1;
            }
        }
        
        return ans;
    }
    
    public void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}