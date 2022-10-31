// https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/0
package All_Problems;

import java.util.*;

public class DijkstraAlgorithm {
    
    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        // Min Heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        int[] distArr = new int[V];
        Arrays.fill(distArr, (int) 1e9);
        distArr[S] = 0;
        pq.add(new Pair(S, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;
            int dist = p.dist;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);

                if (dist + edgeWeight < distArr[adjNode]) {
                    distArr[adjNode] = dist + edgeWeight;
                    pq.add(new Pair(adjNode, distArr[adjNode]));
                }
            }
        }

        return distArr;
    }
}
