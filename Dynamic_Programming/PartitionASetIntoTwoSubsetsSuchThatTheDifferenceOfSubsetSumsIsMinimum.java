// https://www.codingninjas.com/codestudio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494
package Dynamic_Programming;

public class PartitionASetIntoTwoSubsetsSuchThatTheDifferenceOfSubsetSumsIsMinimum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        System.out.println(minSubsetSumDifference(arr, n));
    }

    public static int minSubsetSumDifference(int[] arr, int n) {
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        boolean[] prev = new boolean[totalSum + 1];

        // Base case
        prev[0] = true;
        if (arr[0] <= totalSum) {
            prev[arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            boolean[] curr = new boolean[totalSum + 1];
            curr[0] = true;
            for (int target = 1; target < totalSum + 1; target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if (arr[ind] <= target) {
                    take = prev[target - arr[ind]];
                }

                curr[target] = take || notTake;
            }
            prev = curr;
        }

        int min = Integer.MAX_VALUE;
        // dp[n - 1][col -> 0 ... totalSum]
        for (int s1 = 0; s1 <= totalSum / 2; s1++) {
            if (prev[s1]) {
                int s2 = totalSum - s1;
                min = Math.min(min, Math.abs(s1 - s2));
            }
        }

        return min;
    }

    /* public static int minSubsetSumDifference(int[] arr, int n) {
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        boolean[][] dp = new boolean[n][totalSum + 1];

        // Base case
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= totalSum) {
            dp[0][arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target < totalSum + 1; target++) {
                boolean notTake = dp[ind - 1][target];
                boolean take = false;
                if (arr[ind] <= target) {
                    take = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = take || notTake;
            }
        }

        int min = Integer.MAX_VALUE;
        // dp[n - 1][col -> 0 ... totalSum]
        for (int s1 = 0; s1 <= totalSum / 2; s1++) {
            if (dp[n - 1][s1]) {
                int s2 = totalSum - s1;
                min = Math.min(min, Math.abs(s1 - s2));
            }
        }

        return min;
    } */
}
