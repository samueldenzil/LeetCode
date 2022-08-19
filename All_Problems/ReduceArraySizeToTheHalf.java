// https://leetcode.com/problems/reduce-array-size-to-the-half/
package All_Problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ReduceArraySizeToTheHalf {

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        System.out.println(minSetSize(arr));
    }

    public static int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int it : arr) {
            if (!map.containsKey(it)) {
                map.put(it, 0);
            }
            map.put(it, map.get(it) + 1);
        }

        List<Integer> freq = new ArrayList<>(map.values());
        freq.sort((a, b) -> (b - a));

        int count = 0;
        int totalEl = n;
        int i = 0;
        while (totalEl > n / 2) {
            totalEl -= freq.get(i);
            count++;
            i++;
        }

        return count;
    }
}
