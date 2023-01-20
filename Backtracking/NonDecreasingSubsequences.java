// https://leetcode.com/problems/non-decreasing-subsequences/
package Backtracking;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class NonDecreasingSubsequences {

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        System.out.println(findSubsequences(nums));
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        helper(0, nums, set, new ArrayList<>());
        return new ArrayList<>(set);
    }

    private static void helper(int i, int[] nums, Set<List<Integer>> set, List<Integer> curr) {
        // base case
        if (i == nums.length) {
            if (curr.size() >= 2) {
                set.add(new ArrayList<>(curr));
            }
            return;
        }

        // take
        if (curr.size() == 0 || curr.get(curr.size() - 1) <= nums[i]) {
            curr.add(nums[i]);
            helper(i + 1, nums, set, curr);
            curr.remove(curr.size() - 1);
        }

        // not take
        helper(i + 1, nums, set, curr);
    }
}
