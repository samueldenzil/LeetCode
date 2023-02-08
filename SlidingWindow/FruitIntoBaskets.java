// https://leetcode.com/problems/fruit-into-baskets/
package SlidingWindow;

import java.util.Map;
import java.util.HashMap;

public class FruitIntoBaskets {

    public static void main(String[] args) {
        int[] fruits = {0, 1, 2, 2};
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int ans = 0;

        while (end < n) {
            map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[start], map.get(fruits[start]) - 1);
                if (map.get(fruits[start]) == 0) {
                    map.remove(fruits[start]);
                }
                start++;
            }
            ans = Math.max(ans, end - start + 1);
            end++;
        }

        return ans;
    }
}
