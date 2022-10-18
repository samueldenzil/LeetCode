// https://leetcode.com/problems/sum-of-number-and-its-reverse/
package Maths;

public class SumOfNumberAndItsReverse {

    public static void main(String[] args) {
        int num = 443;
        System.out.println(sumOfNumberAndReverse(num));
    }

    public static boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            if (i + reverse(i) == num) {
                return true;
            }
        }
        return false;
    }

    private static int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            int unit = n % 10;
            rev *= 10;
            rev += unit;
            // rev = rev * 10 + unit;
            n /= 10;
        }
        return rev;
    }
}
