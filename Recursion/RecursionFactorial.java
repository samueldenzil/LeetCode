package Recursion;


public class RecursionFactorial {

    public static void main(String[] args) {
        System.out.println(sumOfN(5));
        // System.out.println(factorial(5));
    }

    public static int factorial(int n) {
        // base case
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static int sumOfN(int n) {
        // base case
        if (n == 1) {
            return 1;
        }
        return n + sumOfN(n - 1);
    }
}
