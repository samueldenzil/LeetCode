// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/
package All_Problems;

import java.util.Map;
import java.util.HashMap;

public class MinimumRoundsToCompleteAllTasks {

    public static void main(String[] args) {
        int[] tasks = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        System.out.println(minimumRounds(tasks));
    }

    public static int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int round = 0;
        for (int task : map.keySet()) {
            int count = map.get(task);
            if (count == 1) {
                return -1;
            }

            if (count % 3 == 0) {    // 3 * k
                round += (count / 3);
            } else {    // (3 * k) + 1 or (3 * k) + 2
                round += (count / 3) + 1;
            }
        }
        return round;
    }
}
