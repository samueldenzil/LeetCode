// https://leetcode.com/problems/subsets-ii/
package Backtracking;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class SubsetsII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        helper(0, nums, set, new ArrayList<>());
        return new ArrayList<>(set);
    }

    private static void helper(int ind, int[] nums, Set<List<Integer>> set, List<Integer> curr) {
        // base case
        if (ind == nums.length) {
            set.add(new ArrayList<>(curr));
            return;
        }

        // take
        curr.add(nums[ind]);
        helper(ind + 1, nums, set, curr);
        curr.remove(curr.size() - 1);

        // not take
        helper(ind + 1, nums, set, curr);
    }
}
