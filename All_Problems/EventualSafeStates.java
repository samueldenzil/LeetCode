// https://practice.geeksforgeeks.org/problems/eventual-safe-states/1
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class EventualSafeStates {

    public List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        // Your code here
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        boolean[] check = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                checkDFS(i, adj, vis, pathVis, check);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean checkDFS(int node, List<List<Integer>> adj, boolean[] vis, boolean[] pathVis, boolean[] check) {
        vis[node] = true;
        pathVis[node] = true;

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                if (checkDFS(it, adj, vis, pathVis, check)) {   // when the node is not visited
                    check[node] = false;
                    return true;
                }
            } else if (pathVis[it]) {   // if the node has been previously visited, but it has been visited on the same path
                check[node] = false;
                return true;
            }
        }

        check[node] = true;
        pathVis[node] = false;
        return false;
    }
}
