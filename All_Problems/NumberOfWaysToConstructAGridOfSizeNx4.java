// https://practice.geeksforgeeks.org/problems/number-of-ways2552/1
package All_Problems;

import java.util.Arrays;

public class NumberOfWaysToConstructAGridOfSizeNx4 {

    public static void main(String[] args) {
        int N = 5;
        System.out.println(arrangeTiles(N));
    }

    // TC: O(n)
    // SC: O(n)
    public static long arrangeTiles(int N){
        long[] dp = new long[N + 1];

        // base case
        for (int i = 0; i < 4; i++) {
            if (i <= N) {
                dp[i] = 1;
            }
        }

        for (int ind = 4; ind <= N; ind++) {
            long lastTileHorizontally = dp[ind - 1];
            long last4TileVertically = dp[ind - 4];

            dp[ind] = lastTileHorizontally + last4TileVertically;
        }

        return dp[N];
    }


    // TC: O(n)
    // SC: O(n) + O(n)
    /* public static long arrangeTiles(int N){
        long[] dp = new long[N + 1];
        Arrays.fill(dp, -1);

        return helper(N, dp);
    }

    private static long helper(int ind, long[] dp) {
        // base case
        if (ind < 4) {
            return 1;
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        long lastTileHorizontally = helper(ind - 1, dp);
        long last4TileVertically = helper(ind - 4, dp);

        return dp[ind] = lastTileHorizontally + last4TileVertically;
    } */
}
