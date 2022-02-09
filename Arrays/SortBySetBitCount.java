// https://practice.geeksforgeeks.org/problems/sort-by-set-bit-count1153/1
package Arrays;

import java.util.Arrays;

public class SortBySetBitCount {

    public static void main(String[] args) {
        Integer[] arr = {5, 2, 3, 9, 4, 6, 7, 15, 32};
        sortBySetBitCount(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void sortBySetBitCount(Integer[] arr, int n) {
        // Your code goes here
        sort(arr, 0, n - 1);
    }

    static void merge(Integer[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (getSetBitCount(L[i]) >= getSetBitCount(R[j])) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void sort(Integer[] arr, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    static int getSetBitCount(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            int lastDigit = n & 1;
            if (lastDigit == 1) {
                count++;
            }
            n = n >> 1;
        }

        return count;
    }
}
