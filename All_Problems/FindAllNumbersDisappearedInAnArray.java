package All_Problems;
// Google Interview Question
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

import java.util.ArrayList;
import java.util.List;

class FindAllNumbersDisappearedInAnArray {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
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
//            int correct = nums[i] - 1;
            
            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }
        
        return list;
    }
    
    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}