// https://practice.geeksforgeeks.org/problems/bipartite-graph/1
package Graph;

import java.util.Arrays;
import java.util.ArrayList;

public class BipartiteGraph_DFS {

    public static void main(String[] args) {
        int V = 7;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(4).add(3);
        adj.get(3).add(4);

        adj.get(4).add(5);
        adj.get(5).add(4);

        adj.get(4).add(6);
        adj.get(6).add(4);

        adj.get(1).add(6);
        adj.get(6).add(1);

        System.out.println(isBipartite(V, adj));
    }

    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, adj, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean dfs(int node, int col, ArrayList<ArrayList<Integer>> adj, int[] color) {
        color[node] = col;

        for (int it : adj.get(node)) {
            if (color[it] == -1) {
                if (!dfs(it, 1 - col, adj, color)) {
                    return false;
                }
            } else if (color[it] == col) {
                return false;
            }
        }

        return true;
    }
}
