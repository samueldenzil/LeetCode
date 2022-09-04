// https://leetcode.com/problems/strictly-palindromic-number/
package Strings;

public class StrictlyPalindromicNumber {

    public static void main(String[] args) {
        int n = 9;
        System.out.println(isStrictlyPalindromic(n));
    }

    public static boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            StringBuilder num = getNum(n, i);
            if (!isPalindrome(num)) {
                return false;
            }
        }
        return true;
    }

    private static StringBuilder getNum(int n, int base) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int remainder = n % base;
            sb.append(remainder);
            n /= base;
        }
        return sb;
    }

    private static boolean isPalindrome(StringBuilder n) {
        int length = n.length();
        int start = 0;
        int end = n.length() - 1;
        while (start < end) {
            if (n.charAt(start) != n.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
