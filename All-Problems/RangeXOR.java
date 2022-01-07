package Bitwise;

public class RangeXOR {

    public static void main(String[] args) {
        // range xor from a -> b = xor(b) ^ xor(a - 1)
        int a = 3;
        int b = 9;

        int ans = xor(b) ^ xor(a - 1);
        System.out.println(ans);
    }

    // this gives xor from 0 to a
    public static int xor(int x) {
        if (x % 4 == 0) {
            return x;
        } else if (x % 4 == 1) {
            return 1;
        } else if (x % 4 == 2) {
            return x + 1;
        } else {
            return 0;
        }
    }
}
