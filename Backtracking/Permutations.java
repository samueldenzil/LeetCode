// https://leetcode.com/problems/permutations/
package Backtracking;

import java.util.List;
import java.util.ArrayList;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        helper(0, nums, ans, vis, new ArrayList<>());
        return ans;
    }

    private static void helper(int ind, int[] nums, List<List<Integer>> ans, boolean[] vis, List<Integer> curr) {
        // base case
        if (ind == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                curr.add(nums[i]);
                vis[i] = true;
                helper(ind + 1, nums, ans, vis, curr);
                curr.remove(curr.size() - 1);
                vis[i] = false;
            }
        }
    }
}
