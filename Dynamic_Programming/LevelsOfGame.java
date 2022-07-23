// https://practice.geeksforgeeks.org/problems/levels-of-game/1
package Dynamic_Programming;

import java.util.Arrays;

public class LevelsOfGame {

    public static void main(String[] args) {
        int h = 20, m = 8;
        System.out.println(maxLevel(h, m));
    }

    public static int maxLevel(int h, int m) {
        // code here
        int[][] dp = new int[2001][2001];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(h, m, 0, dp);
    }

    private static int helper(int h, int m, int prevRoad, int[][] dp) {
        if (h <= 0 || m <= 0) {
            return -1;
        }

        if (dp[h][m] != -1) {
            return dp[h][m];
        }

        int R1 = (int) -1e9;
        int R2 = (int) -1e9;
        int R3 = (int) -1e9;

        if (prevRoad != 1) {
            R1 = 1 + helper(h + 3, m + 2, 1, dp);
        }
        if (prevRoad != 2) {
            R2 = 1 + helper(h - 5, m - 10, 2, dp);
        }
        if (prevRoad != 3) {
            R3 = 1 + helper(h - 20, m + 5, 3, dp);
        }

        return dp[h][m] = Math.max(R1, Math.max(R2, R3));
    }
}
