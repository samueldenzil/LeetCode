// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
package Strings;

public class MinimumRemoveToMakeValidParentheses {

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }

    public static String minRemoveToMakeValid(String s) {
        char[] letters = s.toCharArray();
        int count = 0;

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == '(') {
                count++;
            } else if (letters[i] == ')') {
                if (count > 0) {
                    count--;
                } else {
                    letters[i] = 0;
                }
            }
        }

        count = 0;
        for (int i = letters.length - 1; i >= 0; i--) {
            if (letters[i] == ')') {
                count++;
            } else if (letters[i] == '(') {
                if (count > 0) {
                    count--;
                } else {
                    letters[i] = 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : letters) {
            if (c != 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
