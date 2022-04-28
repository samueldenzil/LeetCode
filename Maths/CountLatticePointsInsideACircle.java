// https://leetcode.com/problems/count-lattice-points-inside-a-circle/
package Maths;

import java.util.Set;
import java.util.HashSet;

public class CountLatticePointsInsideACircle {

    public static void main(String[] args) {
        int[][] circles = {{2, 2, 2}, {3, 4, 1}};
        System.out.println(countLatticePoints(circles));
    }

    public static int countLatticePoints(int[][] circles) {
        Set<String> set = new HashSet<>();

        for (int[] circle : circles) {

            int x = circle[0];
            int y = circle[1];
            int r = circle[2];

            for (int i = x - r; i <= x + r; i++) {
                for (int j = y - r; j <= y + r; j++) {

                    if ((i - x) * (i - x) + (j - y) * (j - y) <= r * r) {
                        set.add(i + "," + j);
                    }
                }
            }
        }

        return set.size();
    }
}
