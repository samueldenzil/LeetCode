// https://leetcode.com/problems/count-distinct-numbers-on-board/
package Maths;

public class CountDistinctNumbersOnBoard {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(distinctIntegers(n));
    }

    public static int distinctIntegers(int n) {
        if (n == 1) {
            return 1;
        }
        return n - 1;
    }
}
