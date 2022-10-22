// https://leetcode.com/problems/contains-duplicate-ii/
package All_Problems;

import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicateII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // edge case
        if (k == 0) {
            return false;
        }

        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < Math.min(k, n); i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        for (int i = k; i < n; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.remove(nums[i - k]);
            set.add(nums[i]);
        }

        return false;
    }
}
