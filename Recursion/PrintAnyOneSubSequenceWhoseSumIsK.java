package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAnyOneSubSequenceWhoseSumIsK {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int k = 2;
        printSubseq(nums, k);
    }

    public static void printSubseq(int[] nums, int k) {
        helper(0, new ArrayList<>(), 0, nums, k);
    }

    private static boolean helper(int index, List<Integer> currentList, int sum, int[] nums, int k) {
        // Base Case
        if (index == nums.length) {
            if (sum == k) {
                System.out.println(currentList);
                return true;
            } else {
                return false;
            }
        }

        currentList.add(nums[index]);
        sum += nums[index];
        if (helper(index + 1, currentList, sum, nums, k)) {
            return true;
        }

        currentList.remove(currentList.size() - 1);
        sum -= nums[index];
        return helper(index + 1, currentList, sum, nums, k);
    }
}
