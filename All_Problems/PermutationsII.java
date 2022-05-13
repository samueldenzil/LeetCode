// https://leetcode.com/problems/permutations-ii/
package All_Problems;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class PermutationsII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        boolean[] visited = new boolean[nums.length];

        helper(set, nums, visited, new ArrayList<>());

        return new ArrayList<>(set);
    }

    private static void helper(Set<List<Integer>> set, int[] nums, boolean[] visited, List<Integer> currentList) {
        if (currentList.size() == nums.length) {
            set.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                currentList.add(nums[i]);
                visited[i] = true;
                helper(set, nums, visited, currentList);
                visited[i] = false;
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
