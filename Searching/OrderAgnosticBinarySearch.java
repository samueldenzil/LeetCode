package Searching;

public class OrderAgnosticBinarySearch {

    public static void main(String[] args) {
//        int[] arr = {2, 3, 4, 15, 16, 18, 22, 45, 89};
        int arr[] = {10, 9, 8, 7, 6, 5};
        int target = 10;
        int ans = OrderAgnosticBS(arr, target);
        System.out.println(ans);
    }

    static int OrderAgnosticBS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean isAscending;

        // Checking if starting element is less than last element
        // is so then the array is sorted in ascending order
        if (arr[start] < arr[end]) {
            isAscending = true;
        }
        // else the array is sorted in descending order
        else {
            isAscending = false;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            // here I'm again making a check is array sorted in ascending order
            // if yes execute this block of code
            if (isAscending) {
                if (target < arr[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            // else execute this block of code
            else {
                if (target > arr[mid]) {
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
