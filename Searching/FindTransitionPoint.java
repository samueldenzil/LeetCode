package Searching;
// https://practice.geeksforgeeks.org/problems/find-transition-point-1587115620/1/
// Amazon Interview Question

public class FindTransitionPoint {

    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(binarySearch(arr));
    }

    public static int binarySearch(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        if (arr[0] == 1) return 0;  // when there are no 0's in the array

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] + 1 == arr[mid + 1]) {
                return mid + 1;
            } else if (arr[mid] == 0) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return -1;
    }
}
