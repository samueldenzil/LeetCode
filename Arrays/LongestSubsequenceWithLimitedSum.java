// https://leetcode.com/problems/longest-subsequence-with-limited-sum/
package Arrays;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 1};
        int[] queries = {3, 10, 21};
        System.out.println(Arrays.toString(answerQueries(nums, queries)));
    }

    public static int[] answerQueries(int[] nums, int[] queries) {
        int m = queries.length;
        int[] ans = new int[m];
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        int i = 0;
        for (int q : queries) {
            ans[i] = binarySearch(nums, q);
            i++;
        }

        return ans;
    }

    private static int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans + 1;
    }
}
