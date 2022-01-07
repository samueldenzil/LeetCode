package Bitwise;

public class PowerOfTwo {

    public static void main(String[] args) {
        int n = 0;
        boolean ans = (n & (n - 1)) == 0;
        if (n == 0) {
            // exception case
            ans = false;
        }

        System.out.println(ans);
    }
}
