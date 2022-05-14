// https://leetcode.com/problems/contains-duplicate/
package Arrays;

import java.util.Set;
import java.util.HashSet;

class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }

    // T: O(n)  S: O(n)
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num))
                return true;

            set.add(num);
        }

        return false;
    }

    // T: O(nLog(n))    S: O(1)
    /* public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    } */
}

