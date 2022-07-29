// https://leetcode.com/problems/longest-common-subsequence/
package Dynamic_Programming;

class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        System.out.println(longestCommonSubsequence(text1, text2));
    }

    // TC: O(n * m)
    // SC: O(2 * m)
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        int[] prev = new int[m + 1];
        
        // base case
        for (int ind2 = 0; ind2 <= m; ind2++) {
            prev[ind2] = 0;
        }
                
        for (int ind1 = 1; ind1 <= n; ind1++) {
            int[] curr = new int[m + 1];
            for (int ind2 = 1; ind2 <= m; ind2++) {
                char c1 = text1.charAt(ind1 - 1);
                char c2 = text2.charAt(ind2 - 1);
        
                if (c1 == c2) {
                    curr[ind2] = 1 + prev[ind2 - 1];
                } else {
                    curr[ind2] = Math.max(prev[ind2], curr[ind2 - 1]);
                }
            }
            prev = curr;
        }
        
        return prev[m];
    }



    // TC: O(n * m)
    // SC: O(n * m)
    /* public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        
        // base case
        for (int ind2 = 0; ind2 <= m; ind2++) {
            dp[0][ind2] = 0;
        }
        for (int ind1 = 0; ind1 <= n; ind1++) {
            dp[ind1][0] = 0;
        }
        
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                char c1 = text1.charAt(ind1 - 1);
                char c2 = text2.charAt(ind2 - 1);
        
                if (c1 == c2) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                } else {
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }
        
        return dp[n][m];
    } */



    // TC: O(n * m)
    // SC: O(n * m) + O(n + m)
    /* public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return helper(n, m, text1, text2, dp);
    }
    
    private static int helper(int ind1, int ind2, String text1, String text2, int[][] dp) {
        if (ind1 == 0 || ind2 == 0) {
            return 0;
        }
        
        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }
        
        char c1 = text1.charAt(ind1 - 1);
        char c2 = text2.charAt(ind2 - 1);
        
        if (c1 == c2) {
            return dp[ind1][ind2] = 1 + helper(ind1 - 1, ind2 - 1, text1, text2, dp);
        }
        
        return dp[ind1][ind2] = Math.max(helper(ind1 - 1, ind2, text1, text2, dp), helper(ind1, ind2 - 1, text1, text2, dp));
    } */
}