// https://leetcode.com/problems/design-a-text-editor/
package Stacks;

import java.util.Stack;

public class DesignATextEditor {

    static class TextEditor {

        Stack<Character> left;
        Stack<Character> right;

        public TextEditor() {
            left = new Stack<>();
            right = new Stack<>();
        }

        public void addText(String text) {
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                left.add(c);
            }
        }

        public int deleteText(int k) {
            int i = 0;
            while (!left.isEmpty() && i < k) {
                left.pop();
                i++;
            }
            return i;
        }

        public String cursorLeft(int k) {
            while (!left.isEmpty() && k > 0) {
                char c = left.pop();
                right.add(c);
                k--;
            }
            return cursorShiftString();
        }

        public String cursorRight(int k) {
            while (!right.isEmpty() && k > 0) {
                char c = right.pop();
                left.add(c);
                k--;
            }
            return cursorShiftString();
        }

        private String cursorShiftString() {
            StringBuilder sb = new StringBuilder();
            int count = 10;

            while (!left.isEmpty() && count > 0) {
                sb.append(left.pop());
                count--;
            }

            StringBuilder reversed = sb.reverse();
            for (int i = 0; i < reversed.length(); i++) {
                left.add(reversed.charAt(i));
            }

            return reversed.toString();
        }
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor(); // The current text is "|". (The '|' character represents the cursor)
        textEditor.addText("leetcode"); // The current text is "leetcode|".
        System.out.println(textEditor.deleteText(4)); // return 4
        // The current text is "leet|".
        // 4 characters were deleted.
        textEditor.addText("practice"); // The current text is "leetpractice|".
        System.out.println(textEditor.cursorRight(3)); // return "etpractice"
        // The current text is "leetpractice|".
        // The cursor cannot be moved beyond the actual text and thus did not move.
        // "etpractice" is the last 10 characters to the left of the cursor.
        System.out.println(textEditor.cursorLeft(8)); // return "leet"
        // The current text is "leet|practice".
        // "leet" is the last min(10, 4) = 4 characters to the left of the cursor.
        System.out.println(textEditor.deleteText(10)); // return 4
        // The current text is "|practice".
        // Only 4 characters were deleted.
        System.out.println(textEditor.cursorLeft(2)); // return ""
        // The current text is "|practice".
        // The cursor cannot be moved beyond the actual text and thus did not move.
        // "" is the last min(10, 0) = 0 characters to the left of the cursor.
        System.out.println(textEditor.cursorRight(6)); // return "practi"
        // The current text is "practi|ce".
        // "practi" is the last min(10, 6) = 6 characters to the left of the cursor.
    }
}
