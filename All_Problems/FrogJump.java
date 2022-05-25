// https://www.codingninjas.com/codestudio/problems/frog-jump_3621012
package All_Problems;

import java.util.Arrays;

public class FrogJump {

    public static void main(String[] args) {
        int[] heights = {10, 20, 30, 10};
        int n = heights.length;
        System.out.println(frogJump(n, heights));
    }

    // TC: O(n)
    // SC: O(1)
    public static int frogJump(int n, int[] heights) {
        // Write your code here
        int prev = 0;
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int firstStep = prev + Math.abs(heights[i] - heights[i - 1]);
            int secondStep = Integer.MAX_VALUE;
            if (i > 1) {
                secondStep = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }

            int currI = Math.min(firstStep, secondStep);
            prev2 = prev;
            prev = currI;
        }

        return prev;
    }


    // TC: O(n)
    // SC: O(n)
    /* public static int frogJump(int n, int[] heights) {
        // Write your code here
        int[] dp = new int[n];

        // Base case
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int firstStep = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int secondStep = Integer.MAX_VALUE;
            if (i > 1) {
                secondStep = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }

            dp[i] = Math.min(firstStep, secondStep);
        }

        return dp[n - 1];
    } */


    // TC: O(n)
    // SC: O(n) + O(n)
    /* public static int frogJump(int n, int[] heights) {
        // Write your code here
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(n - 1, heights, dp);
    }

    private static int helper(int ind, int[] heights, int[] dp) {
        // Base case
        if (ind == 0) {
            return 0;
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        int left = helper(ind - 1, heights, dp) + Math.abs(heights[ind] - heights[ind - 1]);
        int right = Integer.MAX_VALUE;
        if (ind > 1) {
            right = helper(ind - 2, heights, dp) + Math.abs(heights[ind] - heights[ind - 2]);
        }

        return dp[ind] = Math.min(left, right);
    } */
}
