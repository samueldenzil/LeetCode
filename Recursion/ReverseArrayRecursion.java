package Recursion;

public class ReverseArrayRecursion {

    public static void reverse(int i, int[] arr) {
        int n = arr.length;

        if (i >= n / 2) return;

        int temp = arr[i];
        arr[i] = arr[n - i - 1];
        arr[n - i - 1] = temp;
        reverse(i + 1, arr);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverse(0, arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

