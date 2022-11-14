// https://leetcode.com/problems/reverse-words-in-a-string/
package Strings;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        StringBuilder word = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append(word.reverse());
                word = new StringBuilder();
                if (sb.length() >= 1 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(" ");
                }
            } else {
                word.append(c);
            }
        }
        sb.append(word.reverse());
        if (sb.charAt(sb.length() - 1) == ' ') {
            return sb.substring(0, sb.length() - 1);
        }

        return sb.toString();
    }
}
