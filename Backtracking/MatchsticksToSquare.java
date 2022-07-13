// https://leetcode.com/problems/matchsticks-to-square/
package Backtracking;

import java.util.Arrays;

public class MatchsticksToSquare {

    public static void main(String[] args) {
        int[] matchsticks = {1, 1, 2, 2, 2};
        System.out.println(makesquare(matchsticks));
    }

    public static boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }

        int perimeter = 0;
        for (int matchstick : matchsticks) {
            perimeter += matchstick;
        }

        if (perimeter % 4 != 0) {
            return false;
        }

        int side = perimeter / 4;
        int[] sides = new int[]{side, side, side, side};

        Arrays.sort(matchsticks);
        reverse(matchsticks);

        return helper(matchsticks, 0, sides);
    }

    private static void reverse(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    private static boolean helper(int[] nums, int ind, int[] sides) {
        // base case
        if (ind == nums.length) {
            return sides[0] == 0 && sides[1] == 0 && sides[2] == 0 && sides[3] == 0;
        }

        for (int j = 0; j < 4; j++) {
            if (nums[ind] > sides[j]) {
                continue;
            }
            sides[j] -= nums[ind];
            boolean curr = helper(nums, ind + 1, sides);
            if (curr) {
                return true;
            }
            sides[j] += nums[ind];
        }

        return false;
    }
}
