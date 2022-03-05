// https://leetcode.com/problems/champagne-tower/
package Dynamic_Programming;

public class ChampagneTower {

    public static void main(String[] args) {
        int poured = 1000000000, query_row = 99, query_glass = 99;
        System.out.println(champagneTower(poured, query_row, query_glass));
    }

    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];

        dp[0][0] = (double) poured;

        for (int r = 0; r <= query_row; r++) {
            for (int c = 0; c <= r; c++) {
                double q = (dp[r][c] - 1.0) / 2;

                if (q > 0) {
                    dp[r + 1][c] += q;
                    dp[r + 1][c + 1] += q;
                }
            }
        }

        return Math.min(1, dp[query_row][query_glass]);
    }
}
