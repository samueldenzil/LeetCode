// https://leetcode.com/problems/check-if-it-is-a-straight-line/
package All_Problems;

public class CheckIfItIsAStraightLine {

    public static void main(String[] args) {
        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println(checkStraightLine(coordinates));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;

        int dY = coordinates[1][1] - coordinates[0][1]; // y2 - y1
        int dX = coordinates[1][0] - coordinates[0][0]; // x2 - x1

        for (int i = 2; i < n; i++) {
            int dY_i = coordinates[i][1] - coordinates[0][1];
            int dX_i = coordinates[i][0] - coordinates[0][0];

            if (dY_i * dX != dX_i * dY) {
                return false;
            }
        }

        return true;
    }
}
