// https://leetcode.com/problems/flip-string-to-monotone-increasing/
package Dynamic_Programming;

import java.util.Arrays;

public class FlipStringToMonotoneIncreasing {

    public static void main(String[] args) {
        String s = "00110";
        System.out.println(minFlipsMonoIncr(s));
    }

    // Memoization
    // TC: O(n * 2)
    // SC: O(n * 2) + O(n)
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



    // Tabulation
    // TC: O(n * 2)
    // SC: O(n * 2)
    /* public static int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][2];

        // base case
        dp[n][0] = 0;
        dp[n][1] = 0;

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int prev = 0; prev <= 1; prev++) {
                int flip = Integer.MAX_VALUE;
                int notFlip = Integer.MAX_VALUE;
                if (s.charAt(idx) == '0') {
                    if (prev == 0) {  // 00
                        notFlip = dp[idx + 1][0];   // 00
                        flip = 1 + dp[idx + 1][1];  // 01
                    } else if (prev == 1) {    // 10
                        flip = 1 + dp[idx + 1][1];  // 11
                    }
                } else if (s.charAt(idx) == '1') {
                    if (prev == 0) {  // 01
                        notFlip = dp[idx + 1][1];   // 01
                        flip = 1 + dp[idx + 1][0];  // 00
                    } else if (prev == 1) {    // 11
                        notFlip = dp[idx + 1][1];   // 11
                    }
                }
                dp[idx][prev] = Math.min(flip, notFlip);
            }
        }

        return dp[0][0];
    } */



    // Tabulation + Space Optimization
    // TC: O(n * 2)
    // SC: O(2 * 2) ~ O(1)
    /* public static int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] front = new int[2];

        // base case
        front[0] = 0;
        front[1] = 0;

        for (int idx = n - 1; idx >= 0; idx--) {
            int[] curr = new int[2];
            for (int prev = 0; prev <= 1; prev++) {
                int flip = Integer.MAX_VALUE;
                int notFlip = Integer.MAX_VALUE;
                if (s.charAt(idx) == '0') {
                    if (prev == 0) {  // 00
                        notFlip = front[0];   // 00
                        flip = 1 + front[1];  // 01
                    } else if (prev == 1) {    // 10
                        flip = 1 + front[1];  // 11
                    }
                } else if (s.charAt(idx) == '1') {
                    if (prev == 0) {  // 01
                        notFlip = front[1];   // 01
                        flip = 1 + front[0];  // 00
                    } else if (prev == 1) {    // 11
                        notFlip = front[1];   // 11
                    }
                }
                curr[prev] = Math.min(flip, notFlip);
            }
            front = curr;
        }

        return front[0];
    } */
}
