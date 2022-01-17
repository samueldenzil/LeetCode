package All_Problems;
// https://practice.geeksforgeeks.org/problems/count-the-zeros2550/1/
// Amazon Yahoo Interview Question

public class CountTheZeros {

    public static void main(String[] args) {
        int[] arr = {0, 0, 0};
        System.out.println(arr.length - binarySearch(arr));
    }

    public static int binarySearch(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == arr[mid + 1] + 1) {
                return mid + 1;
            } else if (arr[mid] == 1) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start; // or return end;
    }
}
