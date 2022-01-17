package Bit_Manipulation;


public class SetBits {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(setBits(n));
    }

    public static int setBits(int n) {
        int count = 0;

//        while (n > 0) {
//            n = n - (n & -n);   // n & -n gives the last set bit
//            count++;
//        }

        while (n > 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }
}
