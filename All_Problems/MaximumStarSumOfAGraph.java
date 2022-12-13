// https://leetcode.com/problems/maximum-star-sum-of-a-graph/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class MaximumStarSumOfAGraph {

    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 4, 10, -10, -20};
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}, {3, 5}, {3, 6}};
        int k = 2;
        System.out.println(maxStarSum(vals, edges, k));
    }

    public static int maxStarSum(int[] vals, int[][] edges, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        generateGraph(adj, edges, vals);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < adj.size(); i++) {
            List<Integer> list = new ArrayList<>();
            for (Pair it : adj.get(i)) {
                int w = it.w;
                list.add(w);
            }
            list.sort((a, b) -> (b - a));
            int sum = vals[i];
            for (int j = 0; j < Math.min(k, list.size()); j++) {
                sum = Math.max(sum, sum + list.get(j));
            }
            // System.out.println(i + " " + sum);
            ans = Math.max(ans, sum);
        }

        return ans;
    }

    private static void generateGraph(List<List<Pair>> adj, int[][] edges, int[] vals) {
        int n = vals.length;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(new Pair(v, vals[v]));
            adj.get(v).add(new Pair(u, vals[u]));
        }
    }

    static class Pair {
        int v;
        int w;

        Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
