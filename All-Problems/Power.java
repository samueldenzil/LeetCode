package Bitwise;

public class Power {

    public static void main(String[] args) {
        int base = 3;
        int y = 8;

        System.out.println(power(base, y));
    }

    public static int power(int x, int y) {
        int ans = 1;

        while (y > 0) {
            int lastDigit = y & 1;
            if (lastDigit == 1) {
                // if lastDigit == 0 then ignore it
                ans = ans * x;
            }
            x = x * x;
            y = y >> 1;
        }

        return ans;
    }
}
