package Searching;
public class FloorOfANumber {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 1;
        int ans = binarySearch(arr, target);
        System.out.println(ans);
    }

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // if the target element is in the array then it will return its index as ceiling number
            if (target == arr[mid]) {
                return mid;
            }
            else if (target > arr[mid]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return end;
    }
}
