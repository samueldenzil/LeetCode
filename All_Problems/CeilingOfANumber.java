package All_Problems;
// my approach to solve this problem
public class CeilingOfANumber {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 19;
        int ans = binarySearch(arr, target);
        System.out.println(ans);
    }

    static int binarySearch(int[] arr, int target) {

        // but what if the target element is greater than the greatest element in the array
        if (target > arr[arr.length - 1]) {
            return -1;
        }

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
        return start;
    }
}
