// https://leetcode.com/problems/remove-duplicate-letters
package All_Problems;

import java.util.Stack;

public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }

    public static String removeDuplicateLetters(String s) {
        int[] letters = new int[26];    // this will store the last occurrence of a letter in the given string

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letters[c - 'a'] = i;
        }

        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (visited[c - 'a']) continue;

            // if the stack top is greater than current character we can take the current character before,
            // but we have to check if the stack top character appears after or not
            while (!stack.isEmpty() && stack.peek() - 'a' > c - 'a' && i < letters[stack.peek() - 'a']) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            visited[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
