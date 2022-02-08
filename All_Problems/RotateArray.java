// https://practice.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/1
package All_Problems;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int N = arr.length;
        int D = 2;

        rotateArr(arr, D, N);
        System.out.println(Arrays.toString(arr));
    }

    //Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int[] arr, int d, int n) {
        // add your code here
        // reverse the entire array
        reverseArray(arr, 0, n - 1);

        // reverse the array from 0 to n - d - 1
        reverseArray(arr, 0, n - d - 1);

        // reverse the remaining part of the array
        reverseArray(arr, n - d, n - 1);
    }

    static void reverseArray(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
