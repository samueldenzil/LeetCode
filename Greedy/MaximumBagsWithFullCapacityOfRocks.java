// https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
package Greedy;

import java.util.Arrays;

public class MaximumBagsWithFullCapacityOfRocks {

    public static void main(String[] args) {
        int[] capacity = {2, 3, 4, 5}, rocks = {1, 2, 4, 4};
        int additionalRocks = 2;
        System.out.println(maximumBags(capacity, rocks, additionalRocks));
    }

    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] remainingCapacity = new int[n];

        for (int i = 0; i < n; i++) {
            remainingCapacity[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(remainingCapacity);

        int fullBags = 0;
        for (int i = 0; i < n; i++) {
            if (additionalRocks >= remainingCapacity[i]) {
                additionalRocks -= remainingCapacity[i];
                fullBags++;
            } else {
                break;
            }
        }

        return fullBags;
    }
}
