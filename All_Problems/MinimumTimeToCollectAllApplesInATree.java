// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
package All_Problems;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MinimumTimeToCollectAllApplesInATree {

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);
        System.out.println(minTime(n, edges, hasApple));
    }

    // TC: O(n + edges.length)
    // SC: O(n)
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = generateTree(edges, n);
        return helper(0, -1, adj, hasApple);
    }

    private static int helper(int node, int parent, List<List<Integer>> adj, List<Boolean> hasApple) {
        int time = 0;
        for (int it : adj.get(node)) {
            if (it == parent) {
                continue;
            }

            int timeFromMyChild = helper(it, node, adj, hasApple);
            if (timeFromMyChild > 0 || hasApple.get(it)) {
                time += timeFromMyChild + 2;
            }
        }
        return time;
    }

    private static List<List<Integer>> generateTree(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
}
