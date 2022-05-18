// https://practice.geeksforgeeks.org/problems/minimum-number-in-a-sorted-rotated-array-1587115620/1
package Searching;

public class MinimumNumberInASortedRotatedArray {

    public static void main(String[] args) {
        int[] arr = {6, 11, 24, 37, 42};
        System.out.println(minNumber(arr, 0, arr.length - 1));
    }

    public static int minNumber(int[] arr, int low, int high) {
        // Your code here
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (mid - 1 >= 0 && arr[mid] < arr[mid - 1]) {
                return arr[mid];
            }

            if (arr[mid] > arr[high]) {
                low++;
            } else {
                high--;
            }
        }

        return arr[high];
    }
}
