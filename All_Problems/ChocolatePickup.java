// https://www.codingninjas.com/codestudio/problems/ninja-and-his-friends_3125885
package All_Problems;

import java.util.Arrays;

public class ChocolatePickup {

    public static void main(String[] args) {
        int[][] grid = {
                {2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}
        };
        System.out.println(maximumChocolates(grid.length, grid[0].length, grid));
    }

    // TC: O(n * m * m)
    // SC: O(m * m)
    public static int maximumChocolates(int n, int m, int[][] grid) {
        int[][] front = new int[m][m];

        // Base Case
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) {
                    front[j1][j2] = grid[n - 1][j2];
                } else {
                    front[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            int[][] curr = new int[m][m];
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    // Explore all paths of Alice and Bob simultaneously
                    int max = (int) -1e9;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int value = 0;

                            if (j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m) {
                                value = front[j1 + dj1][j2 + dj2];
                            } else {
                                value = (int) -1e9;
                            }
                            if (j1 == j2) {
                                value += grid[i][j1];
                            } else {
                                value += (grid[i][j1] + grid[i][j2]);
                            }
                            max = Math.max(max, value);
                        }
                    }
                    curr[j1][j2] = max;
                }
            }
            front = curr;
        }

        return front[0][m - 1];
    }


    // TC: O(n * m * m)
    // SC: O(n * m * m)
    /* public static int maximumChocolates(int n, int m, int[][] grid) {
        int[][][] dp = new int[n][m][m];

        // Base Case
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) {
                    dp[n - 1][j1][j2] = grid[n - 1][j2];
                } else {
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    // Explore all paths of Alice and Bob simultaneously
                    int max = (int) -1e9;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int curr = 0;

                            if (j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m) {
                                curr = dp[i + 1][j1 + dj1][j2 + dj2];
                            } else {
                                curr = (int) -1e9;
                            }
                            if (j1 == j2) {
                                curr += grid[i][j1];
                            } else {
                                curr += (grid[i][j1] + grid[i][j2]);
                            }
                            max = Math.max(max, curr);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }

        return dp[0][0][m - 1];
    } */


    // TC: O(n * m * m * 9)
    // SC: O(n * m * n) + O(n)
    /* public static int maximumChocolates(int n, int m, int[][] grid) {
        int[][][] dp = new int[n][m][m];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        return helper(0, 0, m - 1, grid, n, m, dp);
    }

    private static int helper(int i, int j1, int j2, int[][] grid, int n, int m, int[][][] dp) {
        // Base case
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
            return (int) -1e9;
        }
        if (i == n - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        // Explore all paths of Alice and Bob simultaneously
        int max = (int) -1e9;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int curr = helper(i + 1, j1 + dj1, j2 + dj2, grid, n, m, dp);
                if (j1 == j2) {
                    curr += grid[i][j1];
                } else {
                    curr += (grid[i][j1] + grid[i][j2]);
                }
                max = Math.max(max, curr);
            }
        }

        return dp[i][j1][j2] = max;
    } */
}
