// https://leetcode.com/problems/most-frequent-number-following-key-in-an-array/
package Arrays;

import java.util.Collections;
import java.util.HashMap;

public class MostFrequentNumberFollowingKeyInAnArray {

    public static void main(String[] args) {
        int[] nums = {1, 100, 200, 1, 100};
        int key = 1;
        System.out.println(mostFrequent(nums, key));
    }

    public static int mostFrequent(int[] nums, int key) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                if (!hm.containsKey(nums[i + 1])) {
                    hm.put(nums[i + 1], 1);
                } else {
                    hm.replace(nums[i + 1], hm.get(nums[i + 1]) + 1);
                }
            }
        }

        int maxValueInMap = (Collections.max(hm.values()));

        int target = -1;
        for (HashMap.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                target = entry.getKey();
            }
        }

        return target;
    }
}
