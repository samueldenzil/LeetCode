// https://leetcode.com/problems/is-graph-bipartite/
package Graph;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class BipartiteGraph_BFS {

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
        int notColored = -1;

        int[] color = new int[n];
        Arrays.fill(color, notColored);

        for (int i = 0; i < n; i++) {
            if (color[i] == notColored) {
                if (!bfs(i, graph, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean bfs(int i, int[][] graph, int[] color) {
        int notColored = -1;
        int c1 = 0;
        int c2 = 1;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(i);
        color[i] = c1;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int it : graph[node]) {
                if (color[it] == notColored) {
                    int oppositeColor = color[node] == c1 ? c2 : c1;
                    color[it] = oppositeColor;
                    queue.add(it);
                } else if (color[it] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }
}