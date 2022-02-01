// https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1/
package Searching;

public class NumberOfOccurrence {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int n = arr.length;
        int x = 4;
        System.out.println(count(arr, n, x));
    }

    static int count(int[] arr, int n, int x) {
        // code here
        int startIndex = binarySearch(arr, x, 0, n - 1, false);

        if (startIndex == -1) return 0;

        int endIndex = binarySearch(arr, x, startIndex, n - 1, true);
        return endIndex - startIndex + 1;
    }

    static int binarySearch(int[] arr, int target, int start, int end, boolean findEndIndex) {

        int index = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                index = mid;
                if (findEndIndex) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }
        }

        return index;
    }
}
