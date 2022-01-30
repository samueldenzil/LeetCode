// https://practice.geeksforgeeks.org/problems/check-if-the-number-is-balanced3014/1/
package All_Problems;

public class CheckIfTheNumberIsBalanced {

    public static void main(String[] args) {
        String N = "1234006";
        System.out.println(balancedNumber(N));
    }

    static Boolean balancedNumber(String N) {
        // your code here
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < N.length() / 2; i++) {
            int c1 = N.charAt(i) - '0';
            int c2 = N.charAt(N.length() - i - 1) - '0';

            sum1 += c1;
            sum2 += c2;
        }

        return sum1 == sum2;
    }
}
