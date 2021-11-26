// https://leetcode.com/problems/find-all-duplicates-in-an-array/

import java.util.ArrayList;
import java.util.List;

class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        for (i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                list.add(nums[i]);
            }
        }
        
        return list;
    }
    
    public void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}