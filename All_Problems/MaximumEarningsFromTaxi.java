// https://leetcode.com/problems/maximum-earnings-from-taxi/
package All_Problems;

import java.util.Arrays;

public class MaximumEarningsFromTaxi {

    public static void main(String[] args) {
        int n = 20;
        int[][] rides = {{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}};
        System.out.println(maxTaxiEarnings(n, rides));
    }

    // TC: O(n) + O(nlogn)
    // SC: O(n)
    public static long maxTaxiEarnings(int n, int[][] rides) {
        // sort the rides according to the start
        Arrays.sort(rides, (a, b) -> a[0] - b[0]);

        long[] dp = new long[rides.length + 1];

        for (int ind = rides.length - 1; ind >= 0; ind--) {
            long notTake = 0 + dp[ind + 1];

            int nextRideIndex = binarySearch(rides[ind][1], rides);

            int start = rides[ind][0];
            int end = rides[ind][1];
            int tip = rides[ind][2];

            long take = (end - start + tip) + dp[nextRideIndex];

            dp[ind] = Math.max(take, notTake);
        }

        return dp[0];
    }


    // Searching for next passenger who can sit in the taxi
    private static int binarySearch(int prevEnd, int[][] rides) {
        int start = 0;
        int end = rides.length - 1;

        int ans = rides.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int nextStart = rides[mid][0];

            if (nextStart >= prevEnd) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }


    // TC: O(n) + O(nlogn)
    // SC: O(n) + O(n)
    /* public static long maxTaxiEarnings(int n, int[][] rides) {
        // sort the rides according to the start
        Arrays.sort(rides, (a, b) -> a[0] - b[0]);

        long[] dp = new long[rides.length];
        Arrays.fill(dp, -1);

        return helper(0, rides, dp);
    }

    private static long helper(int ind, int[][] rides, long[] dp) {
        // Base case
        if (ind >= rides.length) {
            return 0;
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        long notTake = 0 + helper(ind + 1, rides, dp);

        int nextRideIndex = binarySearch(rides[ind][1], rides);

        int start = rides[ind][0];
        int end = rides[ind][1];
        int tip = rides[ind][2];

        long take = (end - start + tip) + helper(nextRideIndex, rides, dp);

        return dp[ind] = Math.max(take, notTake);
    }

    // Searching for next passenger who can sit in the taxi
    private static int binarySearch(int prevEnd, int[][] rides) {
        int start = 0;
        int end = rides.length - 1;

        int ans = rides.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int nextStart = rides[mid][0];

            if (nextStart >= prevEnd) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    } */
}
