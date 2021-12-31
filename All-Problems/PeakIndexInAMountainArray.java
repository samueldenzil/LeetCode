// Google, Facebook Interview Question
// https://leetcode.com/problems/peak-index-in-a-mountain-array/

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // you are in decreasing part of array
                // this may be the answer, but look at left
                // this is why end != mid - 1
                end = mid;
            }
            else if (arr[mid] < arr[mid + 1]) {
                // you are in increasing part of array
                // because we know that mid+1 element > mid element
                start = mid + 1;
            }
        }
        // in the end, start == end and pointing to the largest number because of the two checks above
        // start and end will always try to find max element in the above 2 checks
        // hence when they are pointing to the same element, that is the max one because that is what the check says
        return start; // or return end; as both are equal
    }
}
