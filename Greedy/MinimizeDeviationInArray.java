// https://leetcode.com/problems/minimize-deviation-in-array/
package Greedy;

import java.util.TreeSet;

public class MinimizeDeviationInArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(minimumDeviation(nums));
    }

    public static int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int it : nums) {
            if (it % 2 == 1) {
                set.add(it * 2);
            } else {
                set.add(it);
            }
        }

        int diff = Integer.MAX_VALUE;
        while (true) {
            int maxVal = set.last();
            int minVal = set.first();
            int currDiff = maxVal - minVal;
            diff = Math.min(diff, currDiff);

            if (maxVal % 2 == 1) {
                break;
            }

            set.remove(maxVal);
            set.add(maxVal / 2);
        }

        return diff;
    }
}
