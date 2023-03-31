// https://leetcode.com/problems/minimum-cost-for-tickets/
package Dynamic_Programming;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class MinimumCostForTickets {

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        System.out.println(mincostTickets(days, costs));
    }

    public static int mincostTickets(int[] days, int[] costs) {
        Set<Integer> daySet = new HashSet<>();
        for (int day : days) {
            daySet.add(day);
        }

        int[] dp = new int[366];
        Arrays.fill(dp, -1);

        return helper(1, costs, daySet, dp);
    }

    private static int helper(int day, int[] costs, Set<Integer> daySet, int[] dp) {
        if (day > 365) {
            return 0;
        }

        if (dp[day] != -1) {
            return dp[day];
        }

        int ans;
        if (daySet.contains(day)) {
            ans = Math.min(costs[0] + helper(day + 1, costs, daySet, dp), costs[1] + helper(day + 7, costs, daySet, dp));
            ans = Math.min(ans, costs[2] + helper(day + 30, costs, daySet, dp));
        } else {
            ans = helper(day + 1, costs, daySet, dp);
        }

        return dp[day] = ans;
    }
}
