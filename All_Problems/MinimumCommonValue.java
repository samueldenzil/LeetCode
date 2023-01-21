// https://leetcode.com/problems/minimum-common-value/
package All_Problems;

public class MinimumCommonValue {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3}, nums2 = {2, 4};
        System.out.println(getCommon(nums1, nums2));
    }

    public static int getCommon(int[] nums1, int[] nums2) {
        for (int it : nums1) {
            if (binarySearch(nums2, it)) {
                return it;
            }
        }
        return -1;
    }

    private static boolean binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
