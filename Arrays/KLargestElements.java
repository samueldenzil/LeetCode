// https://practice.geeksforgeeks.org/problems/k-largest-elements4206/1/
package Arrays;

import java.util.Arrays;

public class KLargestElements {

    public static void main(String[] args) {
        int[] arr = {12, 5, 787, 1, 23};
        int n = arr.length;
        int k = 2;
        System.out.println(Arrays.toString(kLargest(arr, n, k)));
    }

    static int[] kLargest(int[] arr, int n, int k) {
        // code here
        int[] ans = new int[k];

        Arrays.sort(arr);

        for (int i = 0; i < k; i++) {
            ans[i] = arr[n - i - 1];
        }

        return ans;
    }
}
