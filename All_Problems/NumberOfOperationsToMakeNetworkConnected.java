// https://leetcode.com/problems/number-of-operations-to-make-network-connected/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class NumberOfOperationsToMakeNetworkConnected {

    public static void main(String[] args) {
        int[][] connections = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        int n = 6;
        System.out.println(makeConnected(n, connections));
    }

    public static int makeConnected(int n, int[][] connections) {
        int noOfCables = connections.length;

        if (noOfCables < n - 1) {
            return -1;
        }

        int disconnectedComputers = 0;
        List<List<Integer>> adj = new ArrayList<>();
        generateGraph(adj, connections, n);

        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis);
                disconnectedComputers++;
            }
        }

        return disconnectedComputers - 1;
    }

    private static void dfs(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, adj, vis);
            }
        }
    }

    private static void generateGraph(List<List<Integer>> adj, int[][] connections, int V) {
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }
}
