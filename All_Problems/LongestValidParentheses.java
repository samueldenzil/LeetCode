// https://leetcode.com/problems/longest-valid-parentheses/
package All_Problems;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
        String s = "()())())())";
        System.out.println(longestValidParentheses(s));
    }

    // TC: O(n)
    // SC: O(n)
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.add(i);
            } else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.add(i);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int endTerminal = s.length();

        while (!stack.isEmpty()) {
            int startTerminal = stack.pop();
            max = Math.max(max, endTerminal - startTerminal - 1);
            endTerminal = startTerminal;
        }
        max = Math.max(max, endTerminal);

        return max;
    }
}
