// https://leetcode.com/problems/find-the-difference-of-two-arrays/
package Arrays;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class FindTheDifferenceOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3}, nums2 = {1, 1, 2, 2};
        System.out.println(findDifference(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(getElementsOnlyInFirstList(nums1, nums2));
        ans.add(getElementsOnlyInFirstList(nums2, nums1));
        return ans;
    }

    private static List<Integer> getElementsOnlyInFirstList(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int it : nums1) {
            set.add(it);
        }

        for (int it : nums2) {
            set.remove(it);
        }

        return new ArrayList<>(set);
    }
}
