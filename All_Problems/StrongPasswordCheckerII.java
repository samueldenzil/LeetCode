// https://leetcode.com/problems/strong-password-checker-ii/
package All_Problems;

public class StrongPasswordCheckerII {

    public static void main(String[] args) {
        String password = "IloveLe3tcode!";
        System.out.println(strongPasswordCheckerII(password));
    }

    public static boolean strongPasswordCheckerII(String password) {
        boolean containsLowerChar = false;
        boolean containsUpperChar = false;
        boolean containsDigit = false;
        boolean containsSpecialChar = false;

        // It has at least 8 characters
        if (password.length() < 8) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) - 'a' >= 0 && password.charAt(i) - 'a' < 26) {
                // It contains at least one lowercase letter
                containsLowerChar = true;
            } else if (password.charAt(i) - 'A' >= 0 && password.charAt(i) - 'A' < 26) {
                // It contains at least one uppercase letter
                containsUpperChar = true;
            } else if (password.charAt(i) - '0' >= 0 && password.charAt(i) - '0' <= 9) {
                // It contains at least one digit
                containsDigit = true;
            } else {
                // It contains at least one special character
                containsSpecialChar = isSpecial(password.charAt(i));
            }

            // It does not contain 2 of the same character in adjacent positions
            if (i + 1 < password.length() && password.charAt(i) == password.charAt(i + 1)) {
                return false;
            }
        }

        return containsLowerChar && containsUpperChar && containsDigit && containsSpecialChar;
    }


    private static boolean isSpecial(char c) {
        if (c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*' || c == '(' || c == ')' || c == '-' || c == '+') {
            return true;
        }
        return false;
    }
}
