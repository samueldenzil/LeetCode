// https://leetcode.com/problems/min-cost-to-connect-all-points/
package All_Problems;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;

public class MinCostToConnectAllPoints {

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(minCostConnectPoints(points));
    }

    public static int minCostConnectPoints(int[][] points) {
        // Min Heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        int cost = 0;

        // StartId, EndId, DistanceBetweenStartToEnd
        // Initially we will be starting from (0, 0, 0), we are storing the index
        pq.offer(new int[] {0, 0, 0});

        Set<Integer> visited = new HashSet<>();

        int num = points.length;
        while (!pq.isEmpty() && visited.size() < num) {
            int[] curr = pq.poll();
            int endId = curr[1];
            int currCost = curr[2];

            // If we have already visited the current node then there is no need to do anything
            if (visited.contains(endId))
                continue;

            cost += currCost;
            visited.add(endId);

            for (int i = 0; i < num; i++) {
                if (!visited.contains(i)) {
                    pq.offer(new int[] {endId, i, distance(points, endId, i)});
                }
            }
        }

        return cost;
    }

    private static int distance(int[][] points, int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
}
