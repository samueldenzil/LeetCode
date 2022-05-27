package All_Problems;
// https://leetcode.com/problems/number-of-1-bits/

public class NumberOf1Bits {

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight(n));
    }
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;

        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    // you need to treat n as an unsigned value
    /* public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1)
                count++;
            n = n >> 1;
        }
        return count;
    } */
}