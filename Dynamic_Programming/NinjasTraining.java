// https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003
package Dynamic_Programming;

import java.util.Arrays;

public class NinjasTraining {

    public static void main(String[] args) {
        int[][] points = {
                {1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}
        };

        System.out.println(ninjaTraining(points.length, points));
    }

    // TC: O(n * 4 * 3)
    // SC: O(4)
    public static int ninjaTraining(int n, int[][] points) {
        int[] prev = new int[4];

        // Base case
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][1], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];

            for (int last = 0; last < 4; last++) {
                for (int task = 0; task < 3; task++) {

                    if (task != last) {
                        int point = points[day][task] + prev[task];
                        temp[last] = Math.max(temp[last], point);
                    }
                }
            }

            prev = temp;
        }

        return prev[3];
    }


    // TC: O(n * 4 * 3)
    // SC: O(n * 4)
    /* public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];

        // Base case
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][1], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;

                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }

        return dp[n - 1][3];
    } */


    // TC: O(n * 4 * 3)
    // SC: O(n + n * 4)
    /* public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return helper(n - 1, 3, points, dp);
    }

    private static int helper(int day, int last, int[][] points, int[][] dp) {
        // Base case
        if (day == 0) {
            int max = 0;

            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    max = Math.max(max, points[day][task]);
                }
            }

            return max;
        }

        if (dp[day][last] != -1) {
            return dp[day][last];
        }

        int max = 0;

        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[day][task] + helper(day - 1, task, points, dp);
                max = Math.max(max, point);
            }
        }

        return dp[day][last] = max;
    } */
}
