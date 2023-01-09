// https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/
package Searching;

public class MaximumCountOfPositiveIntegerAndNegativeInteger {

    public static void main(String[] args) {
        int[] nums = {-2, -1, -1, 1, 2, 3};
        System.out.println(maximumCount(nums));
    }

    public static int maximumCount(int[] nums) {
        int posIdx = firstPositiveNum(nums);
        int negIdx = lastNegativeNum(nums);

        if (posIdx == -1 && negIdx == -1) {
            return 0;
        }

        int pos = nums.length - posIdx;
        int neg = negIdx + 1;

        return Math.max(pos, neg);
    }

    private static int firstPositiveNum(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > 0) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static int lastNegativeNum(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= 0) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
}
