// https://leetcode.com/problems/find-closest-node-to-given-two-nodes/
package All_Problems;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class FindClosestNodeToGivenTwoNodes {

    public static void main(String[] args) {
        int[] edges = {2, 2, 3, -1};
        int node1 = 0, node2 = 1;
        System.out.println(closestMeetingNode(edges, node1, node2));
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        bfs(node1, dist1, edges);

        int[] dist2 = new int[n];
        bfs(node2, dist2, edges);

        int minDistNode = -1;
        int minDistTillNow = Integer.MAX_VALUE;
        for (int node = 0; node < n; node++) {
            if (minDistTillNow > Math.max(dist1[node], dist2[node])) {
                minDistNode = node;
                minDistTillNow = Math.max(dist1[node], dist2[node]);
            }
        }

        return minDistNode;
    }

    private static void bfs(int start, int[] distArr, int[] edges) {
        Arrays.fill(distArr, Integer.MAX_VALUE);
        distArr[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int dist = distArr[node];
            int child = edges[node];
            if (child != -1 && dist + 1 < distArr[child]) {
                distArr[child] = dist + 1;
                queue.add(child);
            }
        }
    }
}
