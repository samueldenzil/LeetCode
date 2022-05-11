// https://leetcode.com/problems/combination-sum-iii/
package All_Problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class CombinationSumIII {

    public static void main(String[] args) {
        int k = 3, n = 7;
        System.out.println(combinationSum3(k, n));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        Set<List<Integer>> set = new HashSet<>();
        helper(set, k, n, new HashSet<>(), 1);
        return new ArrayList<>(set);
    }

    private static void helper(Set<List<Integer>> ans, int noOfElements, int remainingSum, Set<Integer> runningSet, int start) {
        // Base Case
        if (noOfElements == 0) {
            if (remainingSum == 0) {
                ans.add(new ArrayList<>(runningSet));
                return;
            } else {
                return;
            }
        }
        // If the remainingSum is less than zero then it is impossible to get the required sum
        if (remainingSum < 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            runningSet.add(i);
            helper(ans, noOfElements - 1, remainingSum - i, runningSet, i + 1);
            runningSet.remove(i);
        }
    }

    // Bad Time Complexity
    /* public List<List<Integer>> combinationSum3(int k, int n) {
        Set<List<Integer>> set = new HashSet<>();
        helper(set, k, n, new HashSet<>());
        return new ArrayList<>(set);
    }

    private void helper(Set<List<Integer>> ans, int noOfElements, int remainingSum, Set<Integer> runningSet) {
        // Base Case
        if (noOfElements == 0) {
            if (remainingSum == 0) {
                ans.add(new ArrayList<>(runningSet));
                return;
            } else {
                return;
            }
        }
        // If the remainingSum is less than zero then it is impossible to get the required sum
        if (remainingSum < 0) {
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!runningSet.contains(i)) {
                runningSet.add(i);
                helper(ans, noOfElements - 1, remainingSum - i, runningSet);
                runningSet.remove(i);
            }
        }
    } */
}
