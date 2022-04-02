// https://leetcode.com/problems/minimum-bit-flips-to-convert-number
package All_Problems;

public class MinimumBitFlipsToConvertNumber {

    public static void main(String[] args) {
        int start = 10, goal = 7;
        System.out.println(minBitFlips(start, goal));
    }

    public static int minBitFlips(int start, int goal) {
        int count = 0;
        while (start > 0 || goal > 0) {
            int lastStartDigit = start & 1;
            int lastGoalDigit = goal & 1;

            if (lastStartDigit != lastGoalDigit) {
                count++;
            }

            start = start >> 1;
            goal = goal >> 1;
        }

        return count;
    }
}
