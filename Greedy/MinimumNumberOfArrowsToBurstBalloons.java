// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
package Greedy;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (int[] p1, int[] p2) -> {
            // Don't use p1[1 ] - p2[1]. It may overflow
            return p1[0] < p2[0] ? -1 : 1;
        });
//        Arrays.sort(points, (a, b) -> Math.abs(a[0] - b[0]));

        int[] prev = points[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            int currStartPoint = points[i][0];
            int currEndPoint = points[i][1];
            int prevStartPoint = prev[0];
            int prevEndPoint = prev[1];

            if (currStartPoint > prevEndPoint) {    // no overlap
                count++;
                prev = points[i];
            } else {    // overlap
                prev[0] = Math.max(prevStartPoint, currStartPoint);
                prev[1] = Math.min(prevEndPoint, currEndPoint);
            }
        }

        return count;
    }
}
