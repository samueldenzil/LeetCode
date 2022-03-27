// https://leetcode.com/problems/find-the-difference-of-two-arrays/
package Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FindTheDifferenceOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3}, nums2 = {1, 1, 2, 2};
        System.out.println(findDifference(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i : nums1) {
            if (!binarySearch(nums2, i) && !list1.contains(i)) {
                list1.add(i);
            }
        }

        for (int i : nums2) {
            if (!binarySearch(nums1, i) && !list2.contains(i)) {
                list2.add(i);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(list1);
        ans.add(list2);

        return ans;
    }

    public static boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return true;
            }

            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }
        }

        return false;
    }
}
