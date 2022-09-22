// https://practice.geeksforgeeks.org/problems/license-key-formatting/1
package Strings;

public class LicenseKeyFormatting {

    public static void main(String[] args) {
        String S = "2-5g-3-J";
        int K = 2;
        System.out.println(ReFormatString(S, K));
    }

    public static String ReFormatString(String S, int K){
        // code here
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c != '-') {
                if (c - 'a' >= 0 && c - 'z' <= 25) {    // means the c is lower case
                    sb.append(toUpperChar(c));
                } else {
                    sb.append(c);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            ans.append(c);
            if (i != 0 && i % K == 0) {
                ans.append('-');
            }
        }

        return ans.toString();
    }

    private static char toUpperChar(char c) {
        int index = c - 'a';
        return (char) ('A' + index);
    }
}
