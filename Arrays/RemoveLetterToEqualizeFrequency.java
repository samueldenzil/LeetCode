// https://leetcode.com/problems/remove-letter-to-equalize-frequency/
package Arrays;

public class RemoveLetterToEqualizeFrequency {

    public static void main(String[] args) {
        String word = "abcc";
        System.out.println(equalFrequency(word));
    }

    public static boolean equalFrequency(String word) {
        int n = word.length();
        int[] letters = new int[26];
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            letters[c - 'a']++;
        }

        // brute force
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            letters[c - 'a']--;
            if (isEqual(letters)) {
                return true;
            }
            letters[c - 'a']++;
        }

        return false;
    }

    private static boolean isEqual(int[] letters) {
        int c = 0;
        for (int it : letters) {
            if (it == 0) {
                continue;
            } else if (c == 0) {
                c = it;
            } else if (c == it) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
