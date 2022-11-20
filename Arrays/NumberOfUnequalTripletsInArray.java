// https://leetcode.com/problems/number-of-unequal-triplets-in-array/
package Arrays;

public class NumberOfUnequalTripletsInArray {

    public static void main(String[] args) {
        int[] nums = {4, 4, 2, 4, 3};
        System.out.println(unequalTriplets(nums));
    }

    public static int unequalTriplets(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
