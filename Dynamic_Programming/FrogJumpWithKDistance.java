package Dynamic_Programming;

public class FrogJumpWithKDistance {

    public static void main(String[] args) {
        int[] heights = {7, 2, 8, 3, 3, 5, 8, 2, 2, 2, 7, 7, 6, 9, 1, 2, 8, 1, 7, 4, 9, 7, 2, 1, 5, 7, 6, 3, 1};
        int n = heights.length;
        int k = 2;

        System.out.println(frogJump(n, heights, k));
    }

    // TC: O(n * k)
    // SC: O(n)
    public static int frogJump(int n, int[] heights, int k) {
        int[] dp = new int[n];

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int currentJump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    min = Math.min(min, currentJump);
                } else
                    break;
            }

            dp[i] = min;
        }

        return dp[n - 1];
    }
}
