// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1/
package All_Problems;

import java.util.ArrayList;

public class DepthFirstSearch {

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];

        dfs(0, visited, adj, ans);

        return ans;
    }

    private void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans) {
        ans.add(node);
        visited[node] = true;

        for (int it : adj.get(node)) {
            if (!visited[it]) {
                dfs(it, visited, adj, ans);
            }
        }
    }
}
