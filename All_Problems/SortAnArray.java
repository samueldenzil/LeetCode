// https://leetcode.com/problems/sort-an-array/
package All_Problems;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class SortAnArray {

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        System.out.println(Arrays.toString(sortArray(nums)));
    }

    public static int[] sortArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxE = Integer.MIN_VALUE;
        int minE = Integer.MAX_VALUE;

        for (int it : nums) {
            map.put(it, map.getOrDefault(it, 0) + 1);
            maxE = Math.max(maxE, it);
            minE = Math.min(minE, it);
        }

        int i = 0;
        for (int it = minE; it <= maxE; it++) {
            while (map.getOrDefault(it, 0) > 0) {
                nums[i] = it;
                i++;
                map.put(it, map.get(it) - 1);
            }
        }

        return nums;
    }
}
