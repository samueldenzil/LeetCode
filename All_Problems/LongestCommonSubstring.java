// https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1
package All_Problems;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String S1 = "ABCDGH";
        String S2 = "ACDGHR";

        System.out.println(longestCommonSubStr(S1, S2, S1.length(), S2.length()));
    }

    // TC: O(n * m)
    // SC: O(2 * m)
    public static int longestCommonSubStr(String S1, String S2, int n, int m) {
        // code here
        int[] prev = new int[m + 1];

        int max = 0;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                char c1 = S1.charAt(i - 1);
                char c2 = S2.charAt(j - 1);

                if (c1 == c2) {
                    curr[j] = 1 + prev[j - 1];
                    max = Math.max(max, curr[j]);
                } else {
                    curr[j] = 0;
                }
            }
            prev = curr;
        }

        return max;
    }


    // TC: O(n * m)
    // SC: O(n * m)
    /* public static int longestCommonSubStr(String S1, String S2, int n, int m) {
        // code here
        int[][] dp = new int[n + 1][m + 1];

        int max = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char c1 = S1.charAt(i - 1);
                char c2 = S2.charAt(j - 1);

                if (c1 == c2) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return max;
    } */
}
