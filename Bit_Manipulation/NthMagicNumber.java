package Bit_Manipulation;

public class NthMagicNumber {

    public static void main(String[] args) {
        int n = 3;
        int newNumber = 0;
        int base = 5;
        while (n > 0) {
            int lastDigit = n & 1;
            newNumber = newNumber + (lastDigit * base);
            base = base * 5;
            n = n >> 1;
        }
        System.out.println(newNumber);
    }
}
