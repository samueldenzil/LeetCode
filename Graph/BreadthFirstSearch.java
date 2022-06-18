// https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1/
package Graph;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BreadthFirstSearch {

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();

                queue.add(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    bfs.add(node);

                    for (int it : adj.get(node)) {
                        if (!visited[it]) {
                            queue.add(it);
                            visited[it] = true;
                        }
                    }
                }
            }
        }

        return bfs;
    }
}
