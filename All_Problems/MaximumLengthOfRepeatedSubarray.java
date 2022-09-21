// https://leetcode.com/problems/maximum-length-of-repeated-subarray/
package All_Problems;

public class MaximumLengthOfRepeatedSubarray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 1}, nums2 = {3, 2, 1, 4, 7};
        System.out.println(findLength(nums1, nums2));
    }

    // TC: O(n * m)
    // SC: O(2 * m)
    public static int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] front = new int[m + 1];
        int max = 0;

        for (int i = n - 1; i >= 0; i--) {
            int[] curr = new int[m + 1];
            for (int j = m - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    curr[j] = 1 + front[j + 1];
                    max = Math.max(max, curr[j]);
                } else {
                    curr[j] = 0;
                }
            }
            front = curr;
        }

        return max;
    }


    // TC: O(n * m)
    // SC: O(n * m)
    /* public static int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n + 1][m + 1];
        int max = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return max;
    } */
}
