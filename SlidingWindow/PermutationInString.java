// https://leetcode.com/problems/permutation-in-string/
package SlidingWindow;

public class PermutationInString {

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for (int i = 0; i < m; i++) {
            map1[s1.charAt(i) - 'a']++;
            if (i < n) {
                map2[s2.charAt(i) - 'a']++;
            }
        }
        if (isAnagram(map1, map2)) {
            return true;
        }

        for (int i = m; i < n; i++) {
            map2[s2.charAt(i - m) - 'a']--;
            map2[s2.charAt(i) - 'a']++;
            if (isAnagram(map1, map2)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isAnagram(int[] map1, int[] map2) {
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }
        return true;
    }
}
