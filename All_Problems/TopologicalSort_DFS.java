// https://practice.geeksforgeeks.org/problems/topological-sort/1
package All_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort_DFS {

    public static void main(String[] args) {
        int V = 6;
        Graph graph = new Graph(V);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(5, 0);
        graph.addEdge(5, 2);
        System.out.println(Arrays.toString(topoSort(V, graph.adj)));
    }

    public static int[] topoSort(int V, List<List<Integer>> adj) {
        // add your code here
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis, stack);
            }
        }

        int size = stack.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = stack.pop();
        }

        return ans;
    }

    private static void dfs(int node, List<List<Integer>> adj, boolean[] vis, Stack<Integer> stack) {
        vis[node] = true;

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, adj, vis, stack);
            }
        }

        stack.push(node);
    }
}
