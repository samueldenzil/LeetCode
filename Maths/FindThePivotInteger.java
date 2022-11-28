// https://leetcode.com/problems/find-the-pivot-integer/
package Maths;

public class FindThePivotInteger {

    public static void main(String[] args) {
        int n = 8;
        System.out.println(pivotInteger(n));
    }

    public static int pivotInteger(int n) {
        for (int i = 1; i <= n; i++) {
            int s1 = getSumOfNNums(i);
            int s2 = getSumOfNNums(n) - s1 + i;
            if (s1 == s2) {
                return i;
            }
        }
        return -1;
    }

    private static int getSumOfNNums(int n) {
        return n * (n + 1) / 2;
    }
}
