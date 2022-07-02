// https://leetcode.com/problems/maximum-units-on-a-truck/
package All_Problems;

import java.util.Arrays;

public class MaximumUnitsOnATruck {

    public static void main(String[] args) {
        int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;
        System.out.println(maximumUnits(boxTypes, truckSize));
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> (b[1] - a[1]));

        int count = 0;
        for (int[] boxType : boxTypes) {
            int numberOfBoxes = boxType[0];
            int numberOfUnitsPerBox = boxType[1];

            if (truckSize - numberOfBoxes > 0) {
                count += (numberOfBoxes * numberOfUnitsPerBox);
                truckSize -= numberOfBoxes;
            } else {
                count += (truckSize * numberOfUnitsPerBox);
                truckSize = 0;
            }
        }

        return count;
    }
}
