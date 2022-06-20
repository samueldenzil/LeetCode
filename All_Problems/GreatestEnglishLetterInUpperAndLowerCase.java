// https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/
package All_Problems;

public class GreatestEnglishLetterInUpperAndLowerCase {

    public static void main(String[] args) {
        String s = "lEeTcOdE";
        System.out.println(greatestLetter(s));
    }

    public static String greatestLetter(String s) {
        int[] lowerLetters = new int[26];
        int[] upperLetters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 65 && c <= 90) {
                upperLetters[c - 'A']++;
            } else {
                lowerLetters[c - 'a']++;
            }
        }

        for (int i = 25; i >= 0; i--) {
            if (upperLetters[i] != 0 && lowerLetters[i] != 0) {
                return String.valueOf((char) (i + 'A'));
            }
        }

        return "";
    }
}
