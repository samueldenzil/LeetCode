// https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1
package All_Problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class PrerequisiteTasks_BFS {

    public static void main(String[] args) {
        int N = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};
        System.out.println(isPossible(N, prerequisites));
    }

    public static boolean isPossible(int N, int[][] prerequisites) {
        // Your Code goes here
        List<List<Integer>> adj = generateAdjList(prerequisites, N);

        // Topological Sort - Kahn's Algorithm (BFS)
        int[] indegree = new int[N];
        for (int i = 0; i < N; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }

        return count == N;
    }

    private static List<List<Integer>> generateAdjList(int[][] prerequisites, int N) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int u = pair[1];
            int v = pair[0];
            adj.get(u).add(v);
        }

        return adj;
    }
}
