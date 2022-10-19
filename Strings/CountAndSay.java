// https://leetcode.com/problems/count-and-say/
package Strings;

public class CountAndSay {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countAndSay(n));
    }

    public static String countAndSay(int n) {
        // base case
        String s = "1";
        if (n == 1) {
            return s;
        }
        for (int i = 2; i <= n; i++) {
            s = helper(s);
        }
        return s;
    }

    private static String helper(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            int count = 0;
            char curr = s.charAt(i);
            while (i < n && s.charAt(i) == curr) {
                count++;
                i++;
            }
            sb.append(count);
            sb.append(curr);
        }
        return sb.toString();
    }
}
