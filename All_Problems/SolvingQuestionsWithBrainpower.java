// https://leetcode.com/problems/solving-questions-with-brainpower/
package All_Problems;

import java.util.Arrays;

public class SolvingQuestionsWithBrainpower {

    public static void main(String[] args) {
        int[][] questions = {{3, 2}, {4, 3}, {4, 4}, {2, 5}};
        System.out.println(mostPoints(questions));
    }

    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        return helper(0, questions, dp);
    }

    private static long helper(int idx, int[][] questions, long[] dp) {
        if (idx >= questions.length) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        // solve this question
        long solve = questions[idx][0] + helper(idx + questions[idx][1] + 1, questions, dp);

        // skip this question
        long skip = helper(idx + 1, questions, dp);

        return dp[idx] = Math.max(solve, skip);
    }
}
