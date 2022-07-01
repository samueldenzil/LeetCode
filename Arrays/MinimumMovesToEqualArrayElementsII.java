// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
package Arrays;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(minMoves2(nums));
    }

    public static int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int median = nums[n / 2];

        int moves = 0;
        for (int i : nums) {
            moves += Math.abs(i - median);
        }

        return moves;
    }
}
