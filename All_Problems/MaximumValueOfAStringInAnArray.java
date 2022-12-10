// https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/
package All_Problems;

public class MaximumValueOfAStringInAnArray {

    public static void main(String[] args) {
        String[] strs = {"alic3", "bob", "3", "4", "00000"};
        System.out.println(maximumValue(strs));
    }

    public static int maximumValue(String[] strs) {
        int max = Integer.MIN_VALUE;
        for (String word : strs) {
            int count = getCount(word);
            max = Math.max(max, count);
        }

        return max;
    }

    private static int getCount(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c - '0' >= 0 && c - '9' <= 9) {
                continue;
            } else {
                return s.length();
            }
        }

        return Integer.parseInt(s);
    }
}
