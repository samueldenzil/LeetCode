// https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/
package All_Problems;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MaximumValueOfKCoinsFromPiles {

    public static void main(String[] args) {
        int[][] matrix = {{1, 100, 3}, {7, 8, 9}};
        List<List<Integer>> piles = new ArrayList<>();

        for (int[] row : matrix) {
            List<Integer> temp = new ArrayList<>();
            for (int it : row) {
                temp.add(it);
            }
            piles.add(temp);
        }

        int k = 2;

        System.out.println(maxValueOfCoins(piles, k));
    }

    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();

        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(0, k, piles, dp);
    }

    private static int helper(int ind, int k, List<List<Integer>> piles, int[][] dp) {
        int n = piles.size();

        // base case
        if (ind == n || k == 0) {
            return 0;
        }

        if (dp[ind][k] != -1) {
            return dp[ind][k];
        }

        int m = piles.get(ind).size();

        int notTake = helper(ind + 1, k, piles, dp);

        int take = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < Math.min(k, m); i++) {
            sum += piles.get(ind).get(i);
            int curr = sum + helper(ind + 1, k - (i + 1), piles, dp);
            take = Math.max(take, curr);
        }

        return dp[ind][k] = Math.max(take, notTake);
    }
}
