// https://leetcode.com/problems/string-compression/
package Strings;

public class StringCompression {

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int length = compress(chars);
        for (int i = 0; i < length; i++) {
            System.out.print(chars[i]);
        }
        System.out.println();
    }

    public static int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int res = 0;

        while (i < n) {
            char currChar = chars[i];
            int count = 0;
            while (i < n && chars[i] == currChar) {
                count++;
                i++;
            }
            chars[res++] = currChar;
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[res++] = c;
                }
            }
        }

        return res;
    }
}
