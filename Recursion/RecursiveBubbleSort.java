package Recursion;

// https://www.geeksforgeeks.org/recursive-bubble-sort/
import java.util.Arrays;

public class RecursiveBubbleSort {

    public static void recursiveBubbleSort(int[] arr, int n) {
        if (n == 0) {
            return;
        }
        boolean flag = true;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                flag = false;
            }
        }
        if (flag) {
            return;
        }
        recursiveBubbleSort(arr, n - 1);
    }

    public static void main(String[] args) {
        // int[] arr = {67, 92, 11, 16, 30, 55};
        int[] arr = {1, 3, 2, 4, 5, 6};
        System.out.println(Arrays.toString(arr));
        recursiveBubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}


