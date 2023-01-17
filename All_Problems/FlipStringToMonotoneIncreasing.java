// https://leetcode.com/problems/flip-string-to-monotone-increasing/
package All_Problems;

import java.util.Arrays;

public class FlipStringToMonotoneIncreasing {

    public static void main(String[] args) {
        String s = "00110";
        System.out.println(minFlipsMonoIncr(s));
    }

    public static int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(0, 0, s, n, dp);
    }

    private static int helper(int idx, int prev, String s, int n, int[][] dp) {
        // base case
        if (idx >= n) {
            return 0;
        }

        if (dp[idx][prev] != -1) {
            return dp[idx][prev];
        }

        int flip = Integer.MAX_VALUE;
        int notFlip = Integer.MAX_VALUE;

        if (s.charAt(idx) == '0') {
            if (prev == 0) {  // 00
                notFlip = helper(idx + 1, 0, s, n, dp);   // 00
                flip = 1 + helper(idx + 1, 1, s, n, dp);  // 01
            } else if (prev == 1) {    // 10
                flip = 1 + helper(idx + 1, 1, s, n, dp);  // 11
            }
        } else if (s.charAt(idx) == '1') {
            if (prev == 0) {  // 01
                notFlip = helper(idx + 1, 1, s, n, dp);   // 01
                flip = 1 + helper(idx + 1, 0, s, n, dp);  // 00
            } else if (prev == 1) {    // 11
                notFlip = helper(idx + 1, 1, s, n, dp);   // 11
            }
        }

        return dp[idx][prev] = Math.min(flip, notFlip);
    }
}
