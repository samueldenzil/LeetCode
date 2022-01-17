package All_Problems;
public class RecursionConcept {

    public static void main(String[] args) {
        function(5);
    }

    public static void function(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        // function(n--);
        function(--n);
        // n-- vs --n
    }
}
