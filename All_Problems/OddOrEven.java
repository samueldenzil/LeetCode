package All_Problems;

// Given a number n find if its odd or even
public class OddOrEven {

    public static void main(String[] args) {
        int n = 44;
        System.out.println(isOdd(n));
    }

    public static boolean isOdd(int n) {
        return (n & 1) == 1;
    }
}
