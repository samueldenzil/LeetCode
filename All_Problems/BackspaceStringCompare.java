// https://leetcode.com/problems/backspace-string-compare/
package All_Problems;

import java.util.Stack;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        String s = "y#fo##f", t = "y#f#o##f";
        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(c);
            }
        }
        StringBuilder s2 = new StringBuilder();
        while (!stack.isEmpty()) {
            s2.append(stack.pop());
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(c);
            }
        }
        StringBuilder t2 = new StringBuilder();
        while (!stack.isEmpty()) {
            t2.append(stack.pop());
        }

        return s2.toString().equals(t2.toString());
    }
}
