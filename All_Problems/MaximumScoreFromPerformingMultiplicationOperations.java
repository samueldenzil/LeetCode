// https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
package All_Problems;

import java.util.Arrays;

public class MaximumScoreFromPerformingMultiplicationOperations {

    public static void main(String[] args) {
        int[] nums = {-5, -3, -3, -2, 7, 1};
        int[] multipliers = {-10, -5, 3, 4, 6};
        System.out.println(maximumScore(nums, multipliers));
    }

    // Tabulation + Space Optimization
    // TC: O(m * m)
    // SC: O(2 * m) -> dp array
    public static int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;

        int[] front = new int[m + 1];

        for (int i = m - 1; i >= 0; i--) {
            int[] curr = new int[m + 1];
            for (int l = i; l >= 0; l--) {
                int e = n - (i - l) - 1;

                int pickLeft = (nums[l] * multipliers[i]) + front[l + 1];
                int pickRight = (nums[e] * multipliers[i]) + front[l];

                curr[l] = Math.max(pickLeft, pickRight);
            }
            front = curr;
        }

        return front[0];
    }


    // Tabulation
    // TC: O(m * m)
    // SC: O(m * m) -> dp array
    /* public static int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;

        int[][] dp = new int[m + 1][m + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int l = i; l >= 0; l--) {
                int e = nums.length - (i - l) - 1;

                int pickLeft = (nums[l] * multipliers[i]) + dp[i + 1][l + 1];
                int pickRight = (nums[e] * multipliers[i]) + dp[i + 1][l];

                dp[i][l] = Math.max(pickLeft, pickRight);
            }
        }

        return dp[0][0];
    } */


    // Memoization
    // TC: O(m * m)
    // SC: O(m * m) + O(m * m) -> auxilary stack space + dp array
    /* public static int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;

        int[][] dp = new int[m][m];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return helper(0, 0, multipliers, nums, dp);
    }

    private static int helper(int i, int l, int[] multipliers, int[] nums, int[][] dp) {
        // base case
        if (i == multipliers.length) {
            return 0;
        }
        if (dp[i][l] != Integer.MIN_VALUE) {
            return dp[i][l];
        }

        int e = nums.length - (i - l) - 1;

        int pickLeft = (nums[l] * multipliers[i]) + helper(i + 1, l + 1, multipliers, nums, dp);
        int pickRight = (nums[e] * multipliers[i]) + helper(i + 1, l, multipliers, nums, dp);

        return dp[i][l] = Math.max(pickLeft, pickRight);
    } */
}
