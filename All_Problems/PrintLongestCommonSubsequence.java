// https://leetcode.com/problems/longest-common-subsequence/
package All_Problems;

public class PrintLongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        System.out.println(longestCommonSubsequence(text1, text2));
    }

    private static String longestCommonSubsequence(String text1, String text2) {
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

        StringBuilder sb = new StringBuilder();

        int ind1 = n;
        int ind2 = m;

        while (ind1 > 0 && ind2 > 0) {
            char c1 = text1.charAt(ind1 - 1);
            char c2 = text2.charAt(ind2 - 1);

            if (c1 == c2) {
                sb.append(c1);
                ind1--;
                ind2--;
            } else if (dp[ind1 - 1][ind2] > dp[ind1][ind2 - 1]) {
                ind1--;
            } else {
                ind2--;
            }
        }

        return sb.reverse().toString();
    }
}
