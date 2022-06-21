// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
package Graph;

import java.util.ArrayList;

public class DetectCycleInAnUndirectedGraph_DFS {

    public static void main(String[] args) {
        int V = 4;
        int E = 2;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        System.out.println(isCycle(V, adj));
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V + 1];

        for (int i = 1; i < V; i++) {
            if (!visited[i]) {
                if (containsCycle(i, -1, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean containsCycle(int node, int prev, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (int it : adj.get(node)) {
            if (!visited[it]) {
                if (containsCycle(it, node, visited, adj)) {
                    return true;
                }
            } else if (it != prev) {
                return true;
            }
        }

        return false;
    }
}
