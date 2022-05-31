// https://leetcode.com/problems/next-greater-element-i/
package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementI {

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreater = new int[nums2.length];

        Arrays.fill(nextGreater, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                nextGreater[stack.peek()] = nums2[i];
                stack.pop();
            }
            stack.add(i);
        }

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int index = getIndex(nums2, nums1[i]);
            ans[i] = nextGreater[index];
        }

        return ans;
    }

    private static int getIndex(int[] nums2, int target) {
        for (int i = 0; i < nums2.length; i++) {
            if (target == nums2[i]) {
                return i;
            }
        }
        return -1;
    }
}
