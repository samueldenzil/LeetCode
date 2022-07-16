// https://practice.geeksforgeeks.org/problems/min-sum-formed-by-digits3551/1
package Arrays;

import java.util.Arrays;

public class MinSumFormedByDigits {

    public static void main(String[] args) {
        int[] arr = {6, 8, 4, 5, 2, 3};
        System.out.println(minSum(arr, arr.length));
    }

    public static long minSum(int[] arr, int n) {
        // Your code goes here
        Arrays.sort(arr);
        long num1 = 0;
        long num2 = 0;

        for (int i = 0; i < n; i += 2) {
            num1 *= 10;
            num1 += arr[i];

            if (i + 1 < n) {
                num2 *= 10;
                num2 += arr[i + 1];
            }
        }

        return num1 + num2;
    }
}
