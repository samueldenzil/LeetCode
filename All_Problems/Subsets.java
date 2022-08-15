// https://leetcode.com/problems/subsets/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, ans, new ArrayList<>());
        return ans;
    }

    private static void helper(int ind, int[] nums, List<List<Integer>> ans, List<Integer> curr) {
        // base case
        if (ind == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // take
        curr.add(nums[ind]);
        helper(ind + 1, nums, ans, curr);
        curr.remove(curr.size() - 1);

        // not take
        helper(ind + 1, nums, ans, curr);
    }
}
