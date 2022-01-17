package Recursion;


public class RecursionNTo1 {

    public static void main(String[] args) {
        function(5);
    }

    public static void function(int n) {
        // base condition
        if (n == 0) {
            return;
        }

        System.out.println(n);
        function(n - 1);
    }
}
