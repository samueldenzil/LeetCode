// https://leetcode.com/problems/first-letter-to-appear-twice/
package All_Problems;

public class FirstLetterToAppearTwice {

    public static void main(String[] args) {
        String s = "abccbaacz";
        System.out.println(repeatedCharacter(s));
    }

    public static char repeatedCharacter(String s) {
        int[] letters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            letters[c - 'a']++;

            if (letters[c - 'a'] > 1) {
                return c;
            }
        }

        return 'a';
    }
}
