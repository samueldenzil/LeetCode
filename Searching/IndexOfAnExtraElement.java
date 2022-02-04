// https://practice.geeksforgeeks.org/problems/index-of-an-extra-element/1
package Searching;

public class IndexOfAnExtraElement {

    public static void main(String[] args) {
        int[] a = {2,4,6,8,9,10,12};
        int[] b = {2,4,6,8,10,12};
        System.out.println(findExtra(a, b, a.length));
    }

    public static int findExtra(int[] a, int[] b, int n) {
        // add code here.
        int extraElement = 0;
        for (int i = 0; i < b.length; i++) {
            extraElement ^= a[i];
            extraElement ^= b[i];
        }
        extraElement ^= a[n - 1];
        return binarySearch(a, extraElement);
    }

    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
