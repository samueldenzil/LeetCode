// https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class MinimumScoreOfAPathBetweenTwoCities_DFS {

    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}};
        System.out.println(minScore(n, roads));
    }

    public static int minScore(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        generateGraph(adj, roads, n);
        boolean[] vis = new boolean[n + 1];

        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;

        helper(1, adj, vis, ans);
        return ans[0];
    }

    private static void helper(int node, List<List<Pair>> adj, boolean[] vis, int[] ans) {
        vis[node] = true;

        for (Pair it : adj.get(node)) {
            ans[0] = Math.min(ans[0], it.dist);
            if (!vis[it.node]) {
                helper(it.node, adj, vis, ans);
            }
        }
    }

    private static void generateGraph(List<List<Pair>> adj, int[][] roads, int n) {
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int dist = road[2];
            adj.get(u).add(new Pair(v, dist));
            adj.get(v).add(new Pair(u, dist));
        }
    }

    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}
