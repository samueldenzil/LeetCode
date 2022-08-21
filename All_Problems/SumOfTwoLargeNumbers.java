// https://practice.geeksforgeeks.org/problems/sum-of-numbers-or-number1219/1
package All_Problems;

public class SumOfTwoLargeNumbers {

    public static void main(String[] args) {
        String X = "25", Y = "23";
        System.out.println(findSum(X, Y));
    }

    public static String findSum(String X, String Y) {
        // code here
        StringBuilder sb = new StringBuilder();
        int i = X.length() - 1;
        int j = Y.length() - 1;

        int carry = 0;
        while (i >= 0 && j >= 0) {
            int d1 = X.charAt(i) - '0';
            int d2 = Y.charAt(j) - '0';
            int temp = carry + d1 + d2;
            sb.append(temp % 10);
            carry = temp / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int d1 = X.charAt(i) - '0';
            int temp = carry + d1;
            sb.append(temp % 10);
            carry = temp / 10;
            i--;
        }
        while (j >= 0) {
            int d2 = Y.charAt(j) - '0';
            int temp = carry + d2;
            sb.append(temp % 10);
            carry = temp / 10;
            j--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        while (true) {
            if (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
                sb.replace(sb.length() - 1, sb.length(), "");
            } else {
                break;
            }
        }
        return sb.reverse().toString();
    }
}
