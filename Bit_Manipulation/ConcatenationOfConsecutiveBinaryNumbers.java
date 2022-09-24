// https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
package Bit_Manipulation;

public class ConcatenationOfConsecutiveBinaryNumbers {

    public static void main(String[] args) {
        int n = 12;
        System.out.println(concatenatedBinary(n));
    }

    public static int concatenatedBinary(int n) {
        int MOD = (int) 1e9 + 7;

        long ans = 0;

        for (int i = 1; i <= n; i++) {
            int noOfShifts = getBinaryNumberLength(i);
            ans = (ans << noOfShifts) % MOD;
            ans += i;
            ans %= MOD;
        }

        return (int) ans % MOD;
    }

    private static int getBinaryNumberLength(int n) {
        return (int) (Math.log(n) / Math.log(2)) + 1;
    }
}
