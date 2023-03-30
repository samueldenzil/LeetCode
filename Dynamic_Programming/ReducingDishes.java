// https://leetcode.com/problems/reducing-dishes/
package Dynamic_Programming;

import java.util.Arrays;

public class ReducingDishes {

    public static void main(String[] args) {
        int[] satisfaction = {-1, -8, 0, 5, -9};
        System.out.println(maxSatisfaction(satisfaction));
    }

    // TC: O(n * n)
    // SC: O(n * n) + O(n * n)
    public static int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);

        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(0, 1, satisfaction, dp);
    }

    private static int helper(int idx, int t, int[] satisfaction, int[][] dp) {
        if (idx >= satisfaction.length) {
            return 0;
        }

        if (dp[idx][t] != -1) {
            return dp[idx][t];
        }

        // take
        int take = (satisfaction[idx] * t) + helper(idx + 1, t + 1, satisfaction, dp);

        // not take
        int notTake = 0 + helper(idx + 1, t, satisfaction, dp);

        return dp[idx][t] = Math.max(take, notTake);
    }


    // TC: O(n * n)
    // SC: O(n * n)
    /* public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);

        int[][] dp = new int[n + 1][n + 2];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int t = 1;  t <= n; t++) {
                // take
                int take = (satisfaction[idx] * t) + dp[idx + 1][t + 1];

                // not take
                int notTake = dp[idx + 1][t];

                dp[idx][t] = Math.max(take, notTake);
            }
        }

        return dp[0][1];
    } */


    // TC: O(n * n)
    // SC: O(2 * n)
    /* public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        
        int[] front = new int[n + 2];
        
        for (int idx = n - 1; idx >= 0; idx--) {
            int[] curr = new int[n + 2];
            for (int t = 1;  t <= n; t++) {
                // take
                int take = (satisfaction[idx] * t) + front[t + 1];

                // not take
                int notTake = front[t];

                curr[t] = Math.max(take, notTake);
            }
            front = curr;
        }
        
        return front[1];
    } */
}
