// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
package All_Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInAnUndirectedGraph_BFS {

    public static void main(String[] args) {
        int V = 4;
        int E = 2;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        System.out.println(isCycle(V, adj));
    }

    private static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V + 1];

        for (int i = 1; i < V; i++) {
            if (!visited[i]) {
                if (containsCycle(i, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean containsCycle(int start, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        Queue<Pair> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(new Pair(start, -1));

        while (!queue.isEmpty()) {
            int node = queue.peek().first;
            int prev = queue.peek().second;
            queue.poll();

            for (int it : adj.get(node)) {
                if (!visited[it]) {
                    queue.add(new Pair(it, node));
                    visited[it] = true;
                } else if (prev != it) {
                    return true;
                }
            }
        }

        return false;
    }
}
