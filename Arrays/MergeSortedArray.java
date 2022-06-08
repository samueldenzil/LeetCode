// https://leetcode.com/problems/merge-sorted-array
package Arrays;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = nums1.length - nums2.length;
        int n = nums2.length;

        System.out.println("Array before merging: ");
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));

        System.out.println("\n After merging: ");
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = nums1.length - 1;
        m--;
        n--;

        // storing the values from the end of nums1
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[k] = nums1[m];
                m--;
            } else {
                nums1[k] = nums2[n];
                n--;
            }
            k--;
        }

        while (m >= 0) {
            nums1[k] = nums1[m];
            m--;
            k--;
        }
        while (n >= 0) {
            nums1[k] = nums2[n];
            n--;
            k--;
        }
    }
}
