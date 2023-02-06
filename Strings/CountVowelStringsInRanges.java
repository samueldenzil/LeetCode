// https://leetcode.com/problems/count-vowel-strings-in-ranges/
package Strings;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class CountVowelStringsInRanges {

    public static void main(String[] args) {
        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        System.out.println(Arrays.toString(vowelStrings(words, queries)));
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int[] prefixSum = new int[words.length];
        if (isStartAndEndVowel(words[0], set)) {
            prefixSum[0] = 1;
        }
        for (int i = 1; i < words.length; i++) {
            if (isStartAndEndVowel(words[i], set)) {
                prefixSum[i] = 1;
            }
            prefixSum[i] += prefixSum[i - 1];
        }

        int q = 0;
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];

            int count = prefixSum[end];
            if (start - 1 >= 0) {   // subtracting the part which is not in the range
                count -= prefixSum[start - 1];
            }
            ans[q++] = count;
        }

        return ans;
    }

    private static boolean isStartAndEndVowel(String word, Set<Character> set) {
        char firstChar = word.charAt(0);
        char lastChar = word.charAt(word.length() - 1);
        return set.contains(firstChar) && set.contains(lastChar);
    }
}
