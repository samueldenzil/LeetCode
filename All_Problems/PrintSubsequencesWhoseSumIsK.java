package All_Problems;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequencesWhoseSumIsK {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int k = 2;
        System.out.println(printSubseq(nums, k));
    }

    public static List<List<Integer>> printSubseq(int[] nums, int k) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, 0, new ArrayList<>(), 0, nums, k);
        return list;
    }

    private static void helper(List<List<Integer>> list, int index, List<Integer> currentList, int sum, int[] nums, int k) {
        // Base case
        if (index == nums.length) {
            if (sum == k) {
                list.add(new ArrayList<>(currentList));
            }
            return;
        }

        // take the current element
        currentList.add(nums[index]);
        sum += nums[index];
        helper(list, index + 1, currentList, sum, nums, k);
        currentList.remove(currentList.size() - 1);
        sum -= nums[index];
        // not take the current element
        helper(list, index + 1, currentList, sum, nums, k);
    }
}
