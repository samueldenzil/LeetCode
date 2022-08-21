// https://leetcode.com/problems/group-anagrams/
package Strings;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            String anagramWord = getAnagramWord(word);
            if (!map.containsKey(anagramWord)) {
                map.put(anagramWord, new ArrayList<>());
            }
            map.get(anagramWord).add(word);
        }

        List<List<String>> ans = new ArrayList<>();
        for (String word : map.keySet()) {
            List<String> row = new ArrayList<>(map.get(word));
            ans.add(row);
        }

        return ans;
    }

    private static String getAnagramWord(String word) {
        int[] letters = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            letters[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < letters.length; i++) {
            while (letters[i] != 0) {
                sb.append('a' + i);
                letters[i]--;
            }
        }

        return sb.toString();
    }
}
