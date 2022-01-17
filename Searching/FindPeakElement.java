package Searching;
// Google, Facebook Interview Question
// https://leetcode.com/problems/find-peak-element/

// This question is word to word same as "Peak Index in a Mountain Array"
// https://leetcode.com/problems/peak-index-in-a-mountain-array/

class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // you are in the decreasing part of array
                end = mid;
            }
            else if (nums[mid] < nums[mid + 1]) {
                // you are in the ascending part of array
                start = mid + 1;
            }
        }
        return start;
    }
}
