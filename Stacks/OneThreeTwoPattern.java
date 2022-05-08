// https://leetcode.com/problems/132-pattern
package Stacks;

import java.util.Stack;

public class OneThreeTwoPattern {

    public static void main(String[] args) {
        int[] nums = {9, 4, 2, 8, 3, 1, 2};
        System.out.println(find132pattern(nums));
    }

    public static boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();   // this will maintain nums[j]
        int thirdElement = Integer.MIN_VALUE;   // this will maintain nums[k]

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < thirdElement) {   // nums[i] < nums[k]
                return true;
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                thirdElement = Math.max(thirdElement, stack.pop());
            }
            stack.add(nums[i]);
        }

        return false;
    }
}
