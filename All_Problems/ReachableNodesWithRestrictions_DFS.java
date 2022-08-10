// https://leetcode.com/problems/reachable-nodes-with-restrictions/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class ReachableNodesWithRestrictions_DFS {

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}};
        int[] restricted = {4, 5};
        System.out.println(reachableNodes(n, edges, restricted));
    }

    public static int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> adj = getList(edges, n);
        int[] visited = new int[n];

        for (int it : restricted) {
            visited[it] = -1;
        }

        visited[0] = 1;
        int[] count = new int[1];

        dfs(0, adj, visited, count);
        return count[0];
    }

    private static void dfs(int node, List<List<Integer>> adj, int[] visited, int[] count) {
        visited[node] = 1;
        count[0]++;
        for (int it : adj.get(node)) {
            if (visited[it] == 0) {
                dfs(it, adj, visited, count);
            }
        }
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
