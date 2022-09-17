// https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class PrerequisiteTasks_DFS {

    public static void main(String[] args) {
        int N = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};
        System.out.println(isPossible(N, prerequisites));
    }

    public static boolean isPossible(int N, int[][] prerequisites) {
        // Your Code goes here
        List<List<Integer>> adj = generateAdjList(prerequisites, N);

        boolean[] vis = new boolean[N];
        boolean[] pathVis = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, pathVis)) {    // if cycle detected then we cannot complete all tasks
                    return false;
                }
            }
        }

        return true;
    }

    // checking if the graph contains cycle
    private static boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                if (dfs(it, adj, vis, pathVis)) {
                    return true;
                }
            } else if (pathVis[it]) {
                return true;
            }
        }

        pathVis[node] = false;
        return false;
    }

    private static List<List<Integer>> generateAdjList(int[][] prerequisites, int N) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int u = pair[1];
            int v = pair[0];
            adj.get(u).add(v);
        }

        return adj;
    }
}
