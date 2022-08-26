// https://practice.geeksforgeeks.org/problems/counting-elements-in-two-arrays/1
package All_Problems;

import java.util.Arrays;
import java.util.ArrayList;

public class CountingElementsInTwoArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 7, 9};
        int[] arr2 = {0, 1, 2, 1, 1, 4};
        System.out.println(countEleLessThanOrEqual(arr1, arr2, arr1.length, arr2.length));
    }

    public static ArrayList<Integer> countEleLessThanOrEqual(int[] arr1, int[] arr2, int m, int n) {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(arr2);
        for (int it : arr1) {
            ans.add(binarySearch(it, arr2, n));
        }
        return ans;
    }

    private static int binarySearch(int target, int[] arr, int n) {
        int start = 0;
        int end = n - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= target) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans + 1;
    }
}
