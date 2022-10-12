// https://leetcode.com/problems/increasing-triplet-subsequence/
package All_Problems;

public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 0, 4, 6};
        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {
        int left = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > mid) {
                return true;
            } else if (nums[i] > left && nums[i] < mid) {
                mid = nums[i];
            } else if (nums[i] < left) {
                left = nums[i];
            }
        }

        return false;
    }
}
