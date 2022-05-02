// https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/
package Strings;

public class RemoveDigitFromNumberToMaximizeResult {

    public static void main(String[] args) {
        String number = "123";
        char digit = '3';
        System.out.println(removeDigit(number, digit));
    }

    public static String removeDigit(String number, char digit) {
        int length = number.length();
        StringBuilder sb = new StringBuilder();
        boolean isRemoved = false;
        for (int i = 0; i < length; i++) {
            char c = number.charAt(i);
            if (!isRemoved && i + 1 < length && c == digit && c < number.charAt(i + 1)) {
                isRemoved = true;
            } else {
                sb.append(c);
            }
        }

        int i = sb.length() - 1;
        while (!isRemoved) {
            char c = sb.charAt(i);
            if (c == digit) {
                sb.replace(i, i + 1, "");
                isRemoved = true;
            }
            i--;
        }
        return sb.toString();
    }
}
