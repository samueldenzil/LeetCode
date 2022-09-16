// https://leetcode.com/problems/find-original-array-from-doubled-array/
package All_Problems;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class FindOriginalArrayFromDoubledArray {

    public static void main(String[] args) {
        int[] changed = {1, 3, 4, 2, 6, 8};
        System.out.println(Arrays.toString(findOriginalArray(changed)));
    }

    public static int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int it : changed) {
            if (!map.containsKey(it)) {
                map.put(it, 0);
            }
            map.put(it, map.get(it) + 1);
        }

        Arrays.sort(changed);
        List<Integer> list = new ArrayList<>();
        for (int it : changed) {
            if (map.getOrDefault(it, 0) == 0) {
                continue;
            }
            if (map.getOrDefault(it * 2, 0) == 0) {
                return new int[0];
            }
            map.put(it, map.get(it) - 1);
            map.put(it * 2, map.get(it * 2) - 1);
            list.add(it);
        }

        int[] original = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            original[i] = list.get(i);
        }

        return original;
    }
}
