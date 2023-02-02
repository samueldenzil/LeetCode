// https://leetcode.com/problems/greatest-common-divisor-of-strings/
package Strings;

public class GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        String str1 = "ABCABC", str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        int n = Math.min(str1.length(), str2.length());
        int i = 0;
        int prefixEnd = -1;

        while (i < n) {
            if (isDivisible(str1, str2, i + 1) && isDivisible(str2, str1, i + 1)) {
                prefixEnd = i;
            }
            i++;
        }

        return prefixEnd != -1 ? str1.substring(0, prefixEnd + 1) : "";
    }

    private static boolean isDivisible(String s, String t, int prefixEnd) {
        int i = 0;
        int prefixStart = 0;

        while (i < s.length()) {
            if (s.charAt(i) != t.charAt(prefixStart)) {
                return false;
            }
            i++;
            prefixStart++;
            prefixStart %= prefixEnd;
        }

        return prefixStart == 0;
    }
}
