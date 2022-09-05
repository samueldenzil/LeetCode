// https://leetcode.com/problems/check-distances-between-same-letters/
package Strings;

import java.util.Arrays;

public class CheckDistancesBetweenSameLetters {

    public static void main(String[] args) {
        String s = "abaccb";
        int[] distance = {1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(checkDistances(s, distance));
    }

    public static boolean checkDistances(String s, int[] distance) {
        int[] letters = new int[26];   // first occurrence of each char
        Arrays.fill(letters, -1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (letters[c - 'a'] != -1) {
                int diff = i - letters[c - 'a'] - 1;
                if (diff != distance[c - 'a']) {
                    return false;
                }
            }
            letters[c - 'a'] = i;
        }

        return true;
    }
}
