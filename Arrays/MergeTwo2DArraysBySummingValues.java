// https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/
package Arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MergeTwo2DArraysBySummingValues {

    public static void main(String[] args) {
        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}}, nums2 = {{1, 4}, {3, 2}, {4, 1}};
        System.out.println(Arrays.deepToString(mergeArrays(nums1, nums2)));
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        Map<Integer, Integer> map = new TreeMap<>();
        int i = 0;
        while (i < m || i < n) {
            if (i < m) {
                updateFrequency(nums1[i][0], nums1[i][1], map);
            }
            if (i < n) {
                updateFrequency(nums2[i][0], nums2[i][1], map);
            }
            i++;
        }

        int[][] ans = new int[map.size()][2];
        i = 0;
        for (int it : map.keySet()) {
            ans[i][0] = it;
            ans[i][1] = map.get(it);
            i++;
        }
        return ans;
    }

    private static void updateFrequency(int key, int val, Map<Integer, Integer> map) {
        map.put(key, map.getOrDefault(key, 0) + val);
    }
}
