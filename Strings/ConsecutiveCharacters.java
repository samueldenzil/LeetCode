// https://leetcode.com/problems/consecutive-characters/
package Strings;

public class ConsecutiveCharacters {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(maxPower(s));
    }

    public static int maxPower(String s) {
        int i = 0;
        int j = 0;
        int max = 0;

        while (i < s.length()) {
            while (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
                j++;
            }
            max = Math.max(max, j - i + 1);
            i++;
            j = i;
        }

        return max;
    }
}
