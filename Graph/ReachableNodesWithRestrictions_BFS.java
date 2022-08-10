// https://leetcode.com/problems/reachable-nodes-with-restrictions/
package Graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class ReachableNodesWithRestrictions_BFS {

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}};
        int[] restricted = {4, 5};
        System.out.println(reachableNodes(n, edges, restricted));
    }

    public static int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> adj = getList(edges, n);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n];

        for (int it : restricted) {
            visited[it] = -1;
        }

        visited[0] = 1;
        queue.add(0);

        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = 1;
            count++;

            for (int it : adj.get(node)) {
                if (visited[it] == 0) {
                    queue.add(it);
                }
            }
        }

        return count;
    }

    private static List<List<Integer>> getList(int[][] edges, int n) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] row : edges) {
            list.get(row[0]).add(row[1]);
            list.get(row[1]).add(row[0]);
        }
        return list;
    }
}
