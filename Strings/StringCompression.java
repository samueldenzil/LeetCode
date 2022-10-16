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
        int j = 0;

        while (j < n) {
            int count = 0;
            char currChar = chars[j];
            while (j < n && currChar == chars[j]) {
                j++;
                count++;
            }

            chars[i++] = currChar;

            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[i++] = c;
                }
            }
        }

        return i;
    }
}
