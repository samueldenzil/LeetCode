// https://leetcode.com/problems/determine-if-string-halves-are-alike/
package Strings;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class DetermineIfStringHalvesAreAlike {

    public static void main(String[] args) {
        String s = "book";
        System.out.println(halvesAreAlike(s));
    }

    public static boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int count = 0;
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (set.contains(s.charAt(i++))) {
                count++;
            }
            if (set.contains(s.charAt(j--))) {
                count--;
            }
        }

        return count == 0;
    }
}
