// https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/
package Arrays;

import java.util.Arrays;

public class MaximumConsecutiveFloorsWithoutSpecialFloors {

    public static void main(String[] args) {
        int bottom = 2, top = 9;
        int[] special = {4, 6};
        System.out.println(maxConsecutive(bottom, top, special));
    }

    public static int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);

        int max = 0;
        int start = bottom;

        for (int sp : special) {
            max = Math.max(max, sp - start);
            start = sp + 1;
        }
        max = Math.max(max, top - special[special.length - 1]);

        return max;
    }
}
