// https://practice.geeksforgeeks.org/problems/reverse-a-string-using-stack/1
package Stacks;

import java.util.Stack;

public class ReverseAStringUsingStack {

    public static void main(String[] args) {
        String S="GeeksforGeeks";
        System.out.println(reverse(S));
    }

    public static String reverse(String S){
        //code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            stack.push(S.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
