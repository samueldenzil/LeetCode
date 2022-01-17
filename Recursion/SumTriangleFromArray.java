package Recursion;

// https://www.geeksforgeeks.org/sum-triangle-from-array/

import java.util.Arrays;

public class SumTriangleFromArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        triangle(arr);
    }

    public static void triangle(int[] arr) {
        // base case
        if (arr.length < 1) {
            return;
        }

        int[] newArr = new int[arr.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i] + arr[i + 1];
        }

        triangle(newArr);
        System.out.println(Arrays.toString(arr));
    }
}
