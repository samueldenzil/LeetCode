package Recursion;

public class CountTheSubsequenceWithSumK {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int k = 2;
        System.out.println(numSubseq(nums, k));
    }

    public static int numSubseq(int[] nums, int k) {
        return helper(0, 0, nums, k);
    }

    private static int helper(int index, int sum, int[] nums, int k) {
        if (index == nums.length) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }

        sum += nums[index];
        int left = helper(index + 1, sum, nums, k);

        sum -= nums[index];
        int right = helper(index + 1, sum, nums, k);

        return left + right;
    }
}
