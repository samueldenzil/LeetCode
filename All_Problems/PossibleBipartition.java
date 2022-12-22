// https://leetcode.com/problems/possible-bipartition/
package All_Problems;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class PossibleBipartition {

    public static void main(String[] args) {
        int n = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        System.out.println(possibleBipartition(n, dislikes));
    }

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        generateGraph(adj, n, dislikes);
        int[] colors = new int[n + 1];
        Arrays.fill(colors, -1);

        for (int i = 1; i < n + 1; i++) {
            if (colors[i] == -1) {
                boolean result = dfs(i, adj, 0, colors);
//                boolean result = bfs(i, adj, colors);
                if (!result) {
                    return false;
                }
            }
        }
        return true;
    }

    // DFS Solution
    private static boolean dfs(int node, List<List<Integer>> adj, int color, int[] colors) {
        colors[node] = color;

        for (int it : adj.get(node)) {
            if (colors[it] == -1) { // the node is uncolored
                boolean result = dfs(it, adj, 1 - color, colors);
                if (!result) {
                    return false;
                }
            } else if (colors[it] == color) {  // it means the node has been colored
                return false;
            }
        }
        return true;
    }

    // BFS Solution
    private static boolean bfs(int node, List<List<Integer>> adj, int[] colors) {
        int notColored = -1;
        int c1 = 0;
        int c2 = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        colors[node] = c1;

        while (!queue.isEmpty()) {
            node = queue.poll();
            for (int it : adj.get(node)) {
                if (colors[it] == notColored) { // the node is uncolored
                    int oppositeColor = colors[node] == c1 ? c2 : c1;
                    queue.add(it);
                    colors[it] = oppositeColor;
                } else if (colors[it] == colors[node]) {    // it means the node has been colored
                    return false;
                }
            }
        }

        return true;
    }

    private static void generateGraph(List<List<Integer>> adj, int n, int[][] dislikes) {
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : dislikes) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }
}
