// https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/
package All_Problems;

import java.util.Hashtable;

public class CheckIfNumberHasEqualDigitCountAndDigitValue {

    public static void main(String[] args) {
        String num = "1210";
        System.out.println(digitCount(num));
    }

    public static boolean digitCount(String num) {
        int n = num.length();
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();

        for (int i = 0; i < n; i++) {
            int c = num.charAt(i) - '0';

            if (!hashtable.containsKey(c)) {
                hashtable.put(c, 1);
            } else {
                int current = hashtable.get(c);
                hashtable.put(c, current + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            int c = num.charAt(i) - '0';
            int digitCount = hashtable.containsKey(i) ? hashtable.get(i) : 0;

            if (c != digitCount) {
                return false;
            }
        }

        return true;
    }
}
