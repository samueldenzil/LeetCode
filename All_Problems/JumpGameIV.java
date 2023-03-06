// https://leetcode.com/problems/jump-game-iv/
package All_Problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class JumpGameIV {

    public static void main(String[] args) {
        int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        System.out.println(minJumps(arr));
    }

    // why dfs does not work?
    // https://leetcode.com/problems/jump-game-iv/discuss/1316467/Jump-Game-iv-or-Why-DFS-will-not-work-Explained
    public static int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();    // element, list of idx
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }

        int steps = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[n];

        queue.add(0);
        vis[0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int currIdx = queue.poll();
                if (currIdx == n - 1) {
                    return steps;
                }

                if (currIdx - 1 >= 0 && !vis[currIdx - 1]) {    // case 1
                    queue.add(currIdx - 1);
                    vis[currIdx - 1] = true;
                }

                if (currIdx + 1 < n && !vis[currIdx + 1]) {     // case 2
                    queue.add(currIdx + 1);
                    vis[currIdx + 1] = true;
                }

                if (map.containsKey(arr[currIdx])) {            // case 3
                    for (int it : map.get(arr[currIdx])) {
                        if (!vis[it]) {
                            queue.add(it);
                            vis[it] = true;
                        }
                    }
                    map.remove(arr[currIdx]);
                }
            }
            steps++;
        }

        return -1;
    }
}
