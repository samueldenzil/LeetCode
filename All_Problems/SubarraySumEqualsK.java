// https://leetcode.com/problems/subarray-sum-equals-k/
package All_Problems;

import java.util.Map;
import java.util.HashMap;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {   // prefix sum
            nums[i] += nums[i - 1];
        }
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();    // <running sum, frequency>
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i] - k)) {
                ans += map.get(nums[i] - k);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return ans;
    }
}
