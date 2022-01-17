package Strings;
// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/

public class SubstringsOfSizeThreeWithDistinctCharacters {

    public static int countGoodSubstrings(String s) {
        int count = 0;
        int k = 3;

        // edge case when strings length is less than 3
        if (s.length() < k) return count;

        if (checkRepetition(s, 0, k)) {
            count++;
        }

        for (int i = k; i < s.length(); i++) {
            if (checkRepetition(s, i - k + 1, k)) {
                count++;
            }
        }
        return count;
    }

    public static boolean checkRepetition(String s, int start, int k) {
        int[] chars = new int[128];

        for (int i = start; i < start + k; i++) {
            char c = s.charAt(i);
            chars[c]++;
            if (chars[c] > 1) {
                return false;
            }
        }
        return true;
    }
}

// below method has better time complexity
/* public static int countGoodSubstrings(String s) {
        int count = 0;

        if (s.length() < 3) return count;

        for (int i = 0; i < s.length() - 3 + 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            char c3 = s.charAt(i + 2);

            if (c1 == c2 || c2 == c3 || c3 == c1) continue;
            count++;
        }

        return count;
    } */
