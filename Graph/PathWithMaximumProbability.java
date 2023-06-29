// https://leetcode.com/problems/path-with-maximum-probability/
//package Graph;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.PriorityQueue;
//import java.util.Queue;
//
//public class PathWithMaximumProbability {
//
//	public static void main(String[] args) {
//		int n = 3;
//		int[][] edges = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
//		double[] succProb = { 0.5, 0.5, 0.2 };
//		int start = 0, end = 2;
//
//		System.out.println(maxProbability(n, edges, succProb, start, end));
//	}
//
//	public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
//		Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
//		for (int i = 0; i < edges.length; i++) {
//			int u = edges[i][0], v = edges[i][1];
//			double pathProb = succProb[i];
//			graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, pathProb));
//			graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, pathProb));
//		}
//
//		double[] maxProb = new double[n];
//		maxProb[start] = 1d;
//
//		Queue<Integer> queue = new LinkedList<>();
//		queue.offer(start);
//		while (!queue.isEmpty()) {
//			int curNode = queue.poll();
//			for (Pair<Integer, Double> neighbor : graph.getOrDefault(curNode, new ArrayList<>())) {
//				int nxtNode = neighbor.getKey();
//				double pathProb = neighbor.getValue();
//
//				// Only update maxProb[nxtNode] if the current path increases
//				// the probability of reach nxtNode.
//				if (maxProb[curNode] * pathProb > maxProb[nxtNode]) {
//					maxProb[nxtNode] = maxProb[curNode] * pathProb;
//					queue.offer(nxtNode);
//				}
//			}
//		}
//
//		return maxProb[end];
//	}
//}
