// https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261
package All_Problems;

import java.util.Arrays;
import java.util.ArrayList;

public class MaximumSumOfNonAdjacentElements {

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};

        ArrayList<Integer> nums = new ArrayList<>();
        for (int i : arr) nums.add(i);

        System.out.println(maximumNonAdjacentSum(nums));
    }

    // TC: O(n)
    // SC: O(1)
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here
        int prev = nums.get(0);
        int prev2 = 0;

        for (int i = 1; i < nums.size(); i++) {
            int pick = nums.get(i) + prev2;
            int notPick = 0 + prev;

            int currI = Math.max(pick, notPick);

            prev2 = prev;
            prev = currI;
        }

        return prev;
    }


    // TC: O(n)
    // SC: O(n)
    /* public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here
        int n = nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // Base case
        dp[0] = nums.get(0);

        for (int i = 1; i < n; i++) {
            int pick = nums.get(i);
            if (i > 1) {
                pick += dp[i - 2];
            }

            int notPick = 0 + dp[i - 1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    } */


    // TC: O(n)
    // SC: O(n) + O(n)
    /* public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here
        int n = nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(n - 1, nums, dp);
    }

    private static int helper(int ind, ArrayList<Integer> nums, int[] dp) {
        // Base case
        if (ind == 0) {
            return nums.get(ind);
        }
        if (ind < 0) {
            return 0;
        }
        if (dp[ind] != -1) {
            return dp[ind];
        }

        int pick = nums.get(ind) + helper(ind - 2, nums, dp);
        int notPick = 0 + helper(ind - 1, nums, dp);

        return dp[ind] = Math.max(pick, notPick);
    } */
}
