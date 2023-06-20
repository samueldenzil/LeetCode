// https://leetcode.com/problems/k-radius-subarray-averages/
package Arrays;

import java.util.Arrays;

public class KRadiusSubarrayAverages {

    public static void main(String[] args) {
        int[] nums = {7, 4, 3, 9, 1, 8, 5, 2, 6};
        int k = 3;
        System.out.println(Arrays.toString(getAverages(nums, k)));
    }

    public static int[] getAverages(int[] nums, int k) {
        int n = nums.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = k; i < (n - k); ++i) {
            int leftBound = i - k, rightBound = i + k;
            long sum = prefix[rightBound + 1] - prefix[leftBound];
            int avg = (int) (sum / (2 * k + 1));
            ans[i] = avg;
        }

        return ans;
    }
}
