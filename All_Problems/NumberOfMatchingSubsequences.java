// https://leetcode.com/problems/number-of-matching-subsequences/
package All_Problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class NumberOfMatchingSubsequences {

    public static void main(String[] args) {
        String s = "abcacadbba";
        String[] words = {"acca", "cdaa", "bccaa"};

        System.out.println(numMatchingSubseq(s, words));
    }

    public static int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            List<Integer> curr = map.get(c);
            curr.add(i);
            map.put(c, curr);
        }

        int count = 0;

        for (String word : words) {
            if (isSubsequence(word, map)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isSubsequence(String word, Map<Character, List<Integer>> map) {
        int latest = -1;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            List<Integer> list = map.get(c);
            latest = binarySearch(list, latest);
            if (latest == -1) {
                return false;
            }
        }

        return true;
    }

    private static int binarySearch(List<Integer> list, int latest) {
        int ans = -1;
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (list.get(mid) > latest) {
                ans = list.get(mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}
