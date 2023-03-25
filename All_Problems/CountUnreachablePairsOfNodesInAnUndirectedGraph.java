// https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class CountUnreachablePairsOfNodesInAnUndirectedGraph {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}};
        System.out.println(countPairs(n, edges));
    }

    public static long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        generateGraph(adj, edges, n);
        boolean[] vis = new boolean[n];

        long ans = 0;
        long remainingNodes = n;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                long sizeOfComponent = helper(i, adj, vis);
                ans += (sizeOfComponent * (remainingNodes - sizeOfComponent));
                remainingNodes -= sizeOfComponent;
            }
        }

        return ans;
    }

    private static long helper(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        long count = 1;

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                count += helper(it, adj, vis);
            }
        }

        return count;
    }

    private static void generateGraph(List<List<Integer>> adj, int[][] edges, int n) {
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
