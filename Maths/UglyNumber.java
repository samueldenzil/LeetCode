// https://leetcode.com/problems/ugly-number/
package Maths;

public class UglyNumber {

    public static void main(String[] args) {
        int n = 6;
        System.out.println(isUgly(n));
    }

    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        for (int it : new int[]{2, 3, 5}) {
            while (n % it == 0) {
                n /= it;
            }
        }
        return n == 1;
    }
}
