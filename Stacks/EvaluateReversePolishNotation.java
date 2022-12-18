// https://leetcode.com/problems/evaluate-reverse-polish-notation/
package Stacks;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (!isOperator(s)) {
                stack.add(Integer.parseInt(s));
                continue;
            }

            // s is an operator
            int secondNum = stack.pop();
            int firstNum = stack.pop();

            int result = 0;
            if (s.equals("+")) {
                result = firstNum + secondNum;
            } else if (s.equals("-")) {
                result = firstNum - secondNum;
            } else if (s.equals("*")) {
                result = firstNum * secondNum;
            } else {
                result = firstNum / secondNum;
            }
            stack.add(result);
        }

        return stack.pop();
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
