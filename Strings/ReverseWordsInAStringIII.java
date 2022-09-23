// https://leetcode.com/problems/reverse-words-in-a-string-iii/
package Strings;

public class ReverseWordsInAStringIII {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        int n = s.length();
        char[] chArr = s.toCharArray();
        int start = 0;
        int end = 0;

        while (end < n) {
            while (end < n && chArr[end] != ' ') {
                end++;
            }
            reverse(start, end - 1, chArr);
            end++;
            start = end;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : chArr) {
            sb.append(c);
        }

        return sb.toString();
    }

    private static void reverse(int start, int end, char[] chArr) {
        while (start < end) {
            char temp = chArr[start];
            chArr[start] = chArr[end];
            chArr[end] = temp;
            start++;
            end--;
        }
    }
}
