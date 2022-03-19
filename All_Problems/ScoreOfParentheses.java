// https://leetcode.com/problems/score-of-parentheses
package All_Problems;

import java.util.Stack;

public class ScoreOfParentheses {

    public static void main(String[] args) {
        String s = "(()(()))";
        System.out.println(scoreOfParentheses(s));
    }

    public static int scoreOfParentheses(String s) {
        int score = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // if we get ( then add 0 onto the stack
            if (c == '(') {
                stack.push(0);
            } else {
                int val = 0;
                while (!stack.isEmpty() && stack.peek() != 0) {
                    val += stack.pop();
                }
                stack.pop();
                val *= 2;
                val = Math.max(val, 1);
                stack.push(val);
            }
        }

        while (!stack.isEmpty()) {
            score += stack.pop();
        }

        return score;
    }
}
