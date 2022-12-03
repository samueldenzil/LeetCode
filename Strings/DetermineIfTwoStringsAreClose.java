// https://leetcode.com/problems/determine-if-two-strings-are-close/
package Strings;

import java.util.Arrays;

public class DetermineIfTwoStringsAreClose {

    public static void main(String[] args) {
        String word1 = "cabbba", word2 = "abbccc";
        System.out.println(closeStrings(word1, word2));
    }

    public static boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n != m) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < n; i++) {
            freq1[word1.charAt(i) - 'a']++;
            freq2[word2.charAt(i) - 'a']++;
        }

        // point 1
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != 0 && freq2[i] != 0) {
                continue;
            } else if (freq1[i] == 0 && freq2[i] == 0) {
                continue;
            } else {
                return false;
            }
        }

        // point 2
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
}
