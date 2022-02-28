// https://leetcode.com/problems/median-of-two-sorted-arrays/

package Arrays;

import java.util.ArrayList;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = merge(nums1, nums2);

        if (arr.size() % 2 == 0) {
            int n1 = arr.get(arr.size() / 2);
            int n2 = arr.get((arr.size() / 2) - 1);
            return (double) (n1 + n2) / 2;
        } else {
            return arr.get(arr.size() / 2);
        }
    }

    public static ArrayList<Integer> merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        ArrayList<Integer> arr = new ArrayList<>(n + m);

        int i = 0, j = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                arr.add(arr1[i]);
                i++;
            } else {
                arr.add(arr2[j]);
                j++;
            }
        }

        while (i < n) {
            arr.add(arr1[i]);
            i++;
        }
        while (j < m) {
            arr.add(arr2[j]);
            j++;
        }

        return arr;
    }
}
