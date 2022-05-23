// https://leetcode.com/problems/percentage-of-letter-in-string/
package Strings;

public class PercentageOfLetterInString {

    public static void main(String[] args) {
        String s = "foobar";
        char letter = 'o';
        System.out.println(percentageLetter(s, letter));
    }

    public static int percentageLetter(String s, char letter) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == letter) {
                count++;
            }
        }

        return (int) Math.floor((count * 100) / (s.length() * 1.0));
    }
}
