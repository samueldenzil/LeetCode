// https://leetcode.com/problems/reverse-integer/
package Maths;

public class ReverseInteger {

    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = (result * 10) + x % 10;
            if (result > Integer.MAX_VALUE) return 0;
            if (result < Integer.MIN_VALUE) return 0;
            x = x / 10;
        }

        return (int) result;
    }
}
