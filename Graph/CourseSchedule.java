// https://practice.geeksforgeeks.org/problems/course-schedule/1
package Graph;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class CourseSchedule {

    public static void main(String[] args) {
        int n = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int m = prerequisites.length;
        System.out.println(Arrays.toString(findOrder(n, m, prerequisites)));
    }

    public static int[] findOrder(int n, int m, int[][] prerequisites) {
        // add your code here
        List<List<Integer>> adj = generateAdjList(prerequisites, n);

        // Topological sort - Kahn's Algo (BFS)
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] ans = new int[n];
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

        return i == n ? ans : new int[]{};
    }

    private static List<List<Integer>> generateAdjList(int[][] prerequisites, int V) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int u = pair[0];
            int v = pair[1];
            adj.get(v).add(u);
        }

        return adj;
    }
}
