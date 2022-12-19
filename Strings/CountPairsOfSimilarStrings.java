// https://leetcode.com/problems/count-pairs-of-similar-strings/
package Strings;

public class CountPairsOfSimilarStrings {

    public static void main(String[] args) {
        String[] words = {"aba", "aabb", "abcd", "bac", "aabc"};
        System.out.println(similarPairs(words));
    }

    public static int similarPairs(String[] words) {
        int n = words.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isSimilar(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        boolean[] letters1 = new boolean[26];
        boolean[] letters2 = new boolean[26];

        for (int i = 0; i < Math.max(n, m); i++) {
            if (i < n) {
                letters1[s1.charAt(i) - 'a'] = true;
            }
            if (i < m) {
                letters2[s2.charAt(i) - 'a'] = true;
            }
        }

        for (int i = 0; i < 26; i++) {
            if ((letters1[i] && !letters2[i]) || (!letters1[i] && letters2[i])) {
                return false;
            }
        }
        return true;
    }
}
