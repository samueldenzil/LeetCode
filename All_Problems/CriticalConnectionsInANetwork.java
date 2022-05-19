// https://leetcode.com/problems/critical-connections-in-a-network/
package All_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInANetwork {

    public static void main(String[] args) {
        int[][] matrix = {{0, 1}, {1, 2}, {2, 0}, {1, 3}};
        int n = matrix.length;
        List<List<Integer>> connections = new ArrayList<>();
        for (int[] row : matrix) {
            List<Integer> temp = new ArrayList<>();
            temp.add(row[0]);
            temp.add(row[1]);
            connections.add(temp);
        }
        System.out.println(criticalConnections(n, connections));
    }

    private static int nextId = 0;

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (List<Integer> connection : connections) {
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];

        int[] lowestId = new int[n];

        tarjanAlgorithm(graph, -1, 0, visited, ans, lowestId);
        return ans;
    }

    private static void tarjanAlgorithm(List<Integer>[] graph, int parentId, int nodeId, boolean[] visited, List<List<Integer>> ans, int[] lowestId) {
        visited[nodeId] = true;

        lowestId[nodeId] = nextId;
        nextId++;

        int currentNodeLowestId = lowestId[nodeId];

        for (int neighbourId : graph[nodeId]) {

            if (neighbourId == parentId) continue;

            if (!visited[neighbourId]) {
                tarjanAlgorithm(graph, nodeId, neighbourId, visited, ans, lowestId);
            }

            lowestId[nodeId] = Math.min(lowestId[nodeId], lowestId[neighbourId]);

            if (currentNodeLowestId < lowestId[neighbourId]) {
                ans.add(Arrays.asList(nodeId, neighbourId));
            }
        }
    }
}
