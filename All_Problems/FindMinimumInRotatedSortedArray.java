package All_Problems;
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int firstElement = (findPivotIndex(nums) + 1) % nums.length;

        return nums[firstElement];
    }

    int findPivotIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // case 1
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            // case 2
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            if (arr[start] >= arr[mid]) {
                // case 3: so all the element after mid will be less than start element and the pivot element will be in the left half, so we can skip the right half
                // and how we are sure that this mid is not the pivot because, if mid was the pivot it would have been returned in case 1 and 2
                end = mid - 1;
            }
            else if (arr[start] < arr[mid]) {
                // case 4: if start < mid then all the element between start and mid will be less than the pivot element, so we can find the pivot element in the right half
                // and how we are sure that this mid is not the pivot because, if mid was the pivot it would have been returned in case 1 and 2
                start = mid + 1;
            }
        }
        return -1;
    }
}