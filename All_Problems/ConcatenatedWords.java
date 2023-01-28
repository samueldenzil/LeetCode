// https://leetcode.com/problems/concatenated-words/
package All_Problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class ConcatenatedWords {

    public static void main(String[] args) {
        String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        System.out.println(findAllConcatenatedWordsInADict(words));
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (isConcatenated(word, set)) {
                ans.add(word);
            }
        }

        return ans;
    }

    private static boolean isConcatenated(String word, Set<String> set) {
        int n = word.length();
        for (int i = 0; i < n; i++) {
            String prefix = word.substring(0, i + 1);
            String suffix = word.substring(i + 1);

            if (set.contains(prefix) && set.contains(suffix)) {
                return true;
            } else if (set.contains(prefix) && isConcatenated(suffix, set)) {
                return true;
            }
        }
        return false;
    }
}
