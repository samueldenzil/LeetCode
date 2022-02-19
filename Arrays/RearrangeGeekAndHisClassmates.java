// https://practice.geeksforgeeks.org/problems/47e5aa3f32aee9e0405f04960f37c8a562d96a2f/1
package Arrays;

import java.util.Arrays;

public class RearrangeGeekAndHisClassmates {

    public static void main(String[] args) {
        long []a = {0, 5, 1, 2, 4, 3};
        prank(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    static void prank(long[] a, int n) {
        // code here
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = a[(int) a[i]];
        }

        for (int i = 0; i < n; i++) a[i] = arr[i];
    }
}
