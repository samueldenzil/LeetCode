package Recursion;


public class RecursionPalindrome {

    public static int palindrome(int n) {
        int digits = (int)(Math.log10(n)) + 1;
        return helper(n, digits);
    }

    public static int helper(int n, int digits) {
        if (n == 0) {
            return 0;
        }

        int remainder = n % 10;
        return remainder * (int)(Math.pow(10, digits - 1)) + helper(n / 10, digits - 1);
    }

    public static void main(String[] args) {
        int n = 9101;
        System.out.println(n == palindrome(n) ? "Yes" : "No");
    }
}
