package All_Problems;
public class RecursionNToN {

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
        System.out.println(n);
    }
}
