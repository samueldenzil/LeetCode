// https://practice.geeksforgeeks.org/problems/bipartite-graph/1/#
package Graph;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BipartiteGraph_BFS {

	public static void main(String[] args) {
		int V = 7;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		adj.get(0).add(1);
		adj.get(1).add(0);

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(2).add(3);
		adj.get(3).add(2);

		adj.get(4).add(3);
		adj.get(3).add(4);

		adj.get(4).add(5);
		adj.get(5).add(4);

		adj.get(4).add(6);
		adj.get(6).add(4);

		adj.get(1).add(6);
		adj.get(6).add(1);

		System.out.println(isBipartite(V, adj));
	}

	public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
		// Code here
		int notColored = -1;
		int[] color = new int[V];
		Arrays.fill(color, notColored);

		for (int i = 0; i < V; i++) {
			if (color[i] == notColored) {
				if (!checkBFS(i, adj, color)) {
					return false;
				}
			}
		}

		return true;
	}

	private static boolean checkBFS(int i, ArrayList<ArrayList<Integer>> adj, int[] color) {
		int notColored = -1;
		int c1 = 0;
		int c2 = 1;
		Queue<Integer> queue = new LinkedList<>();

		queue.add(i);
		color[i] = c1;

		while (!queue.isEmpty()) {
			int node = queue.poll();

			for (int it : adj.get(node)) {
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