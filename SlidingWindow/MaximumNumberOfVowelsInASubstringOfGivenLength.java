// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
package SlidingWindow;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }

    public static int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int count = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }

        int ans = count;
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i - k))) {
                count--;
            }
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
