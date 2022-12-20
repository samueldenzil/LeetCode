// https://leetcode.com/problems/find-if-path-exists-in-graph/
package Graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class FindIfPathExistsInGraph {

    public static void main(String[] args) {
        int n = 3, source = 0, destination = 2;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println(validPath(n, edges, source, destination));
    }

    // DFS Solution
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        generateAdjList(adj, n, edges);
        boolean[] vis = new boolean[n];

        return dfs(source, adj, vis, destination);
    }

    private static boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, int destination) {
        vis[node] = true;
        if (node == destination) {
            return true;
        }

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                boolean result = dfs(it, adj, vis, destination);
                if (result) {
                    return true;
                }
            }
        }

        return false;
    }


    // BFS Solution
    /* public static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        generateAdjList(adj, n, edges);
        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        vis[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == destination) {
                return true;
            }

            for (int it : adj.get(node)) {
                if (!vis[it]) {
                    queue.add(it);
                    vis[it] = true;
                }
            }
        }

        return false;
    } */

    private static void generateAdjList(List<List<Integer>> adj, int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }
}
