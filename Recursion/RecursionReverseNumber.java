package Recursion;


public class RecursionReverseNumber {

    static int sum = 0;

    public static void method1(int n) {
        if (n == 0) {
            return;
        }
        int remainder = n % 10;
        sum = sum * 10 + remainder;
        method1(n / 10);
    }

    public static int method2(int n) {
        // sometimes you might need some extra variables in the argument
        // in that case make another function
        int digits = (int)(Math.log10(n)) + 1;
        return helper(n, digits);
    }

    private static int helper(int n, int digits) {
        // base case
        if (n % 10 == n) {
            return n;
        }
        int remainder = n % 10;
        return remainder * (int)(Math.pow(10, digits - 1)) + helper(n / 10, digits - 1);
    }

    public static void main(String[] args) {
//        method1(2431);
//        System.out.println(sum);

        System.out.println(method2(1234));
    }

}
