// https://leetcode.com/problems/largest-3-same-digit-number-in-string/
package All_Problems;

public class Largest3SameDigitNumberInString {

    public static void main(String[] args) {
        String num = "6777133339";
        System.out.println(largestGoodInteger(num));
    }

    public static String largestGoodInteger(String num) {
        int start = 0;
        int i = 0;

        int ansDigit = -1;

        while (i < num.length()) {
            if ((i + 1) < num.length() && num.charAt(i) == num.charAt(i + 1)) {
                i++;
            } else {
                int length = i - start + 1;
                if (length >= 3) {
                    ansDigit = Math.max(ansDigit, num.charAt(start) - '0');
                }
                start = i + 1;
                i++;
            }
        }

        if (ansDigit != -1) {
            return ansDigit + "" + ansDigit + "" + ansDigit;
        } else {
            return "";
        }
    }
}
