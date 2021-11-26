/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
// https://leetcode.com/problems/find-in-mountain-array/

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeakIndex(mountainArr);

        // searching the target element in the ascending part
        int ans = search(mountainArr, target, 0, peakIndex);

        if (ans == -1) {
            // it means that I was not able to find the target element in the ascending part
            // so trying to search in the decending part
            ans = search(mountainArr, target, peakIndex + 1, mountainArr.length() - 1);
        }

        return ans;
    }

    public int findPeakIndex(MountainArray arr) {
        int start = 0;
        int end = arr.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr.get(mid) > arr.get(mid + 1)) {
                // you are in the decreasing part in the array
                // this index can be the peak but lets check for the previous index
                end = mid;
            }
            else if (arr.get(mid) < arr.get(mid + 1)) {
                // you are in the increasing part in the array
                // because you know that mid+1 element > mid element
                start = mid + 1;
            }
        }
        // the loop will break when start == end and they both are pointing to the peak
        return start;   // or return end;   as both are same
    }

    // Order-agnostic binary search
    public int search(MountainArray arr, int target, int start, int end) {

        boolean isAscending = arr.get(start) < arr.get(end);

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr.get(mid)) {
                return mid;
            }

            if (isAscending) {
                if (target > arr.get(mid)) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
            else {
                if (target > arr.get(mid)) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}