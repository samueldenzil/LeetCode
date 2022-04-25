// https://leetcode.com/problems/intersection-of-multiple-arrays/
package All_Problems;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfMultipleArrays {

    public static void main(String[] args) {
        int[][] nums = {{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}};
        System.out.println(intersection(nums));
    }

    public static List<Integer> intersection(int[][] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int[] num : nums) {
            for (int i : num) {
                if (!hm.containsKey(i)) {
                    hm.put(i, 1);
                } else {
                    int currentFrequency = hm.get(i);
                    hm.put(i, currentFrequency + 1);
                }
            }
        }

        for (int key : hm.keySet()) {
            if (!ans.contains(key) && hm.get(key) == nums.length) {
                ans.add(key);
            }
        }

        ans.sort((a, b) -> a - b);

        return ans;
    }
}
