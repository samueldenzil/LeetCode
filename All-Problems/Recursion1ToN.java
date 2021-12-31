
public class Recursion1ToN {

    public static void main(String[] args) {
        function(5);
    }

    public static void function(int n) {
        // base condition
        if (n == 0) {
            return;
        }

        function(n - 1);
        System.out.println(n);
    }
}
