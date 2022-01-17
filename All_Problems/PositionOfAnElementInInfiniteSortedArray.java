package All_Problems;
// Amazon Interview Question
// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

public class PositionOfAnElementInInfiniteSortedArray {

    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 9, 10, 90, 100, 130,
                140, 160, 170};
        int target = 10;
        System.out.println(ans(arr, target));
    }

    public static int ans(int[] arr, int target) {
        // here I am creating a box of size 2
        int start = 0;
        int end = 1;

        // going through the array and checking if arr[end] < target, and if it becomes greater than the target
        // then the target value should lie before the arr[end]
        while (target > arr[end]) {
            int tempStart = end + 1;
            // after ever iteration the size of the box will be doubled
            end = end + (end - start + 1) * 2;
            start = tempStart;
        }
        return search(arr, target, start, end);
    }

    // normal binary search
    public static int search(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            }
            else if (target < arr[mid]) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
