package Arrays;

import java.util.Map;
import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
                ans[1] = i;
                ans[0] = hm.get(target - nums[i]);
                return ans;
            }
            hm.put(nums[i], i);
        }
        return ans;
    }
}
