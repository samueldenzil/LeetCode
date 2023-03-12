// https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/
package All_Problems;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class CountTheNumberOfVowelStringsInRange {

    public static void main(String[] args) {
        String[] words = {"are", "amy", "u"};
        int left = 0, right = 2;
        System.out.println(vowelStrings(words, left, right));
    }

    public static int vowelStrings(String[] words, int left, int right) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int count = 0;
        for (int i = left; i <= right; i++) {
            if (set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1))) {
                count++;
            }
        }
        return count;
    }
}
