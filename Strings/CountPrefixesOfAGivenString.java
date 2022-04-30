// https://leetcode.com/problems/count-prefixes-of-a-given-string/
package Strings;

public class CountPrefixesOfAGivenString {

    public static void main(String[] args) {
        String[] words = {"a", "b", "c", "ab", "bc", "abc"};
        String s = "abc";
        System.out.println(countPrefixes(words, s));
    }

    public static int countPrefixes(String[] words, String s) {
        int count = 0;

        for (String word : words) {
            if (s.startsWith(word)) {
                count++;
            }
        }

        return count;
    }
}
