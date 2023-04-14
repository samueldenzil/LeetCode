// https://leetcode.com/problems/validate-stack-sequences/
package All_Problems;

import java.util.Stack;

public class ValidateStackSequences {

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed, popped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        for (int it : pushed) {
            stack.add(it);
            // the thing to solve this problem was when to pop the elements from the stack
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        return i == popped.length;
    }
}
