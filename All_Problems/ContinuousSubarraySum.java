// https://leetcode.com/problems/continuous-subarray-sum/
package All_Problems;

import java.util.Map;
import java.util.HashMap;

public class ContinuousSubarraySum {

    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        System.out.println(checkSubarraySum(nums, k));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();    // remainder, index at which it occurs

        map.put(0, -1);
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum % k)) {
                if (i - map.get(prefixSum % k) > 1) {
                    return true;
                }
            }
            map.putIfAbsent(prefixSum % k, i);
        }
        return false;
    }
}
