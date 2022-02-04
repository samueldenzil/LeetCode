// https://leetcode.com/problems/4sum-ii/
package All_Problems;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {-2,-1};
        int[] nums3 = {-1,2};
        int[] nums4 = {0,2};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int a: nums1) {
            for (int b: nums2) {
                if (!map.containsKey(a + b)) {
                    map.put(a + b, 1);
                } else {
                    int temp = map.get(a + b);
                    map.put(a + b, temp + 1);
                }
            }
        }

        for (int c: nums3) {
            for (int d: nums4) {
                if (map.containsKey(-(c + d))) {
                    ans += map.get(-(c + d));
                }
            }
        }

        return ans;
    }
}
