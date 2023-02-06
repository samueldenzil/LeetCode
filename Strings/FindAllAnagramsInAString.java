// https://leetcode.com/problems/find-all-anagrams-in-a-string/
package Strings;

import java.util.List;
import java.util.ArrayList;

public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        List<Integer> ans = new ArrayList<>();
        int[] map = new int[26];

        for (int i = 0; i < n; i++) {
            if (i < m) {
                map[s.charAt(i) - 'a']++;
            }
            map[p.charAt(i) - 'a']--;
        }

        if (isAnagram(map)) {
            ans.add(0);
        }

        for (int i = n; i < m; i++) {
            map[s.charAt(i - n) - 'a']--;
            map[s.charAt(i) - 'a']++;
            if (isAnagram(map)) {
                ans.add(i - n + 1);
            }
        }

        return ans;
    }

    private static boolean isAnagram(int[] map) {
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
