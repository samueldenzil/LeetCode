// https://leetcode.com/problems/number-of-provinces/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = getAdjList(isConnected, n);

        int count = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                count++;
            }
        }

        return count;
    }

    private static void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int it : adj.get(node)) {
            if (!visited[it]) {
                dfs(it, adj, visited);
            }
        }
    }

    private static List<List<Integer>> getAdjList(int[][] isConnected, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        return adj;
    }
}
