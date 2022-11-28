// https://practice.geeksforgeeks.org/problems/add-binary-strings3805/1
package Strings;

public class AddBinaryStrings {

    public static void main(String[] args) {
        String A = "10", B = "1000000";
        System.out.println(addBinary(A, B));
    }

    public static String addBinary(String A, String B) {
        // code here
        int i = A.length() - 1;
        int j = B.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int digit1 = 0;
            if (i >= 0) {
                digit1 = A.charAt(i) - '0';
                i--;
            }
            int digit2 = 0;
            if (j >= 0) {
                digit2 = B.charAt(j) - '0';
                j--;
            }

            int sum = digit1 + digit2 + carry;
            carry = sum / 2;
            sb.append(sum % 2);
        }
        sb.append(carry);
        i = sb.length() - 1;
        while (i >= 0 && sb.charAt(i) == '0') {
            i--;
        }
        return sb.reverse().substring(sb.length() - i - 1);
    }
}
