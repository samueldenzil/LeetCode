// https://practice.geeksforgeeks.org/problems/topological-sort/1
package All_Problems;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class TopologicalSort_BFS {
    
    // Kahn’s algorithm
    public static void main(String[] args) {
        int V = 6;
        Graph graph = new Graph(V);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(5, 0);
        graph.addEdge(5, 2);
        System.out.println(Arrays.toString(topoSort(V, graph.adj)));
    }

    public static int[] topoSort(int V, List<List<Integer>> adj) {
        // add your code here
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] ans = new int[V];
        int i = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans[i] = node;
            i++;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }

        return ans;
    }
}
