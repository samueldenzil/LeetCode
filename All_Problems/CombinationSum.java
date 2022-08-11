// https://leetcode.com/problems/combination-sum/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, target, candidates, ans, new ArrayList<>());
        return ans;
    }

    private static void helper(int ind, int target, int[] candidates, List<List<Integer>> ans, List<Integer> curr) {
        // base case
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (ind >= candidates.length) {
            return;
        }

        // take
        if (candidates[ind] <= target) {
            curr.add(candidates[ind]);
            helper(ind, target - candidates[ind], candidates, ans, curr);
            curr.remove(curr.size() - 1);
        }

        // not take
        helper(ind + 1, target, candidates, ans, curr);
    }
}
