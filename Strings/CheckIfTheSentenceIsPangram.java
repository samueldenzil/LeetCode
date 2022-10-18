// https://leetcode.com/problems/check-if-the-sentence-is-pangram/
package Strings;

public class CheckIfTheSentenceIsPangram {

    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(sentence));
    }

    public static boolean checkIfPangram(String sentence) {
        int[] letters = new int[26];

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            letters[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (letters[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
