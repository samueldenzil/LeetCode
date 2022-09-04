// https://leetcode.com/problems/find-subarrays-with-equal-sum/
package All_Problems;

import java.util.Set;
import java.util.HashSet;

public class FindSubarraysWithEqualSum {

    public static void main(String[] args) {
        int[] nums = {4, 2, 4};
        System.out.println(findSubarrays(nums));
    }

    public static boolean findSubarrays(int[] nums) {
        int k = 2;
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        set.add(sum);
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            if (set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }
}
