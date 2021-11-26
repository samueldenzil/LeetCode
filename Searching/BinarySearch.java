
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 15, 16, 18, 22, 45, 89};
        int target = 2;
        int ans = binarySearch(arr, target);
        System.out.println(ans);
    }

    // return the index
    // return -1 if target does not exist
    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // find the middle element
//            int mid = (start + end) / 2;  // might be possible that the (start + end) exceeds the range of integer in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
