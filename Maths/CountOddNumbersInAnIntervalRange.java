// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
package Maths;

public class CountOddNumbersInAnIntervalRange {

    public static void main(String[] args) {
        int low = 3, high = 7;
        System.out.println(countOdds(low, high));
    }

    public static int countOdds(int low, int high) {
        // If low is even, make it odd.
        if ((low & 1) == 0) {
            low++;
        }

        // low could become greater than high due to incrementation
        // if it is, the answer is 0; otherwise, use the formula.
        return low > high ? 0 : (high - low) / 2 + 1;
    }
}
