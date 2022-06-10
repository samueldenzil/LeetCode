// https://leetcode.com/problems/remove-palindromic-subsequences/
package Strings;

public class RemovePalindromicSubsequences {

    public static void main(String[] args) {
        String s = "baabb";
        System.out.println(removePalindromeSub(s));
    }

    public static int removePalindromeSub(String s) {
        int i = 0;
        int j = s.length() - 1;

        // checking if the current string is a palindrome or not
        boolean isPalindrome = true;

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }

        return isPalindrome ? 1 : 2;
    }
}
