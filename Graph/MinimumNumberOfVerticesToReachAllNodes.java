// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
package Graph;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MinimumNumberOfVerticesToReachAllNodes {

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges.add(new ArrayList<>(Arrays.asList(0, 2)));
        edges.add(new ArrayList<>(Arrays.asList(2, 5)));
        edges.add(new ArrayList<>(Arrays.asList(3, 4)));
        edges.add(new ArrayList<>(Arrays.asList(4, 2)));

        System.out.println(findSmallestSetOfVertices(n, edges));
    }

    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        generateGraph(adj, edges, n);

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 0) {
                ans.add(i);
            }
        }

        return ans;
    }

    // getting the list of incoming edges
    private static void generateGraph(List<List<Integer>> adj, List<List<Integer>> edges, int n) {
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(v).add(u);
        }
    }
}
