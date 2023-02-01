// https://leetcode.com/problems/best-team-with-no-conflicts/
package Dynamic_Programming;

import java.util.Arrays;

public class BestTeamWithNoConflicts {

    public static void main(String[] args) {
        int[] scores = {1, 3, 5, 10, 15};
        int[] ages = {1, 2, 3, 4, 5};
        System.out.println(bestTeamScore(scores, ages));
    }

    public static int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] ageScorePair = new int[n][2];

        for (int i = 0; i < n; i++) {
            ageScorePair[i][0] = ages[i];
            ageScorePair[i][1] = scores[i];
        }

        // Sort in ascending order of age and then by score.
        Arrays.sort(ageScorePair, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, -1, ageScorePair, dp);
    }

    private static int helper(int curr, int prev, int[][] ageScorePair, int[][] dp) {
        // base case
        if (curr == ageScorePair.length) {
            return 0;
        }

        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev + 1];
        }

        // valid
        if (prev == -1 || ageScorePair[curr][1] >= ageScorePair[prev][1]) {
            // take
            int take = ageScorePair[curr][1] + helper(curr + 1, curr, ageScorePair, dp);
            // not take
            int notTake = helper(curr + 1, prev, ageScorePair, dp);
            return dp[curr][prev + 1] = Math.max(take, notTake);
        }

        // not valid
        return dp[curr][prev + 1] = helper(curr + 1, prev, ageScorePair, dp);
    }
}
