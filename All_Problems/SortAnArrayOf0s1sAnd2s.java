// https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1/
package All_Problems;

import java.util.Arrays;

public class SortAnArrayOf0s1sAnd2s {

    public static void main(String[] args) {
        int[] a = {0, 2, 1, 2, 0};
        sort012(a, a.length);
        System.out.println(Arrays.toString(a));
    }
    
    // similar to Dutch National Flag problem
    public static void sort012(int[] a, int n) {
        // code here
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {
            switch (a[mid]) {
                case 0:
                    swap(a, low, mid);
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    swap(a, mid, high);
                    high--;
                    break;
            }
        }
    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

    // Time complexity O(N) + O(N) = O(2N)
    /* public static void sort012(int a[], int n)
    {
        // code here
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                zeroCount++;
            } else if (a[i] == 1) {
                oneCount++;
            }
        }

        for (int i = 0; i < zeroCount; i++) {
            a[i] = 0;
        }
        for (int i = zeroCount; i < zeroCount + oneCount; i++) {
            a[i] = 1;
        }
        for (int i = zeroCount + oneCount; i < n; i++) {
            a[i] = 2;
        }
    } */
}
