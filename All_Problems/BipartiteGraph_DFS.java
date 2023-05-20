// https://leetcode.com/problems/is-graph-bipartite/
package All_Problems;

import java.util.Arrays;

public class BipartiteGraph_DFS {

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };
        System.out.println(isBipartite(graph));
    }

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, graph, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean dfs(int node, int col, int[][] graph, int[] color) {
        color[node] = col;

        for (int it : graph[node]) {
            if (color[it] == -1) {
                if (!dfs(it, 1 - col, graph, color)) {
                    return false;
                }
            } else if (color[it] == col) {
                return false;
            }
        }

        return true;
    }
}
