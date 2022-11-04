// https://leetcode.com/problems/reverse-vowels-of-a-string/
package Strings;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class ReverseVowelsOfAString {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        char[] charArr = s.toCharArray();

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            while (!set.contains(charArr[i]) && i < j) {
                i++;
            }
            while (!set.contains(charArr[j]) && i < j) {
                j--;
            }
            char temp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = temp;
            i++;
            j--;
        }

        return new String(charArr);
    }
}
