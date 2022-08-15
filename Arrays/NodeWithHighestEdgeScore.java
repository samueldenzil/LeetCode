// https://leetcode.com/problems/node-with-highest-edge-score/
package Arrays;

import java.util.HashMap;
import java.util.Map;

public class NodeWithHighestEdgeScore {

    public static void main(String[] args) {
        int[] edges = {1, 0, 0, 0, 0, 7, 7, 5};
        System.out.println(edgeScore(edges));
    }

    public static int edgeScore(int[] edges) {
        int n = edges.length;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long u = i;
            long v = edges[i];
            if (!map.containsKey(v)) {
                map.put(v, (long) 0);
            }
            map.put(v, map.get(v) + u);
        }

        long ans = 0;
        long maxScore = Long.MIN_VALUE;
        for (long node : map.keySet()) {
            if (map.get(node) > maxScore) {
                maxScore = map.get(node);
                ans = node;
            }
        }

        return (int) ans;
    }
}
