// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
package Strings;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII {

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(removeDuplicates(s, k));
    }

    public static String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || c != stack.peek().first) {
                stack.add(new Pair<>(c, 1));
            } else {
                Pair<Character, Integer> top = stack.pop();
                int count = top.second + 1;

                if (count != k)
                    stack.add(new Pair<>(c, count));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.empty()) {
            char c = stack.peek().first;
            int count = stack.pop().second;
            while (count > 0) {
                stringBuilder.append(c);
                count--;
            }
        }

        return stringBuilder.reverse().toString();
    }
}
