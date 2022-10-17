// https://practice.geeksforgeeks.org/problems/alien-dictionary/1
package All_Problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class AlienDictionary {

    public static void main(String[] args) {
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        int N = dict.length;
        int K = 4;
        System.out.println(findOrder(dict, N, K));
    }

    public static String findOrder(String[] dict, int N, int K) {
        // Write your code here
        List<List<Integer>> adj = new ArrayList<>();
        generateGraph(adj, K, dict, N);

        return topologicalSort(adj, K);
    }

    private static String topologicalSort(List<List<Integer>> adj, int V) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Topological Sort - BFS (Kahn’s algorithm)
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append((char) (node + 'a'));
            // node is in your topo sort
            // so please remove it from the indegree

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }

        return sb.toString();
    }

    private static void generateGraph(List<List<Integer>> adj, int K, String[] dict, int N) {
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int length = Math.min(s1.length(), s2.length());

            for (int ptr = 0; ptr < length; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    int u = s1.charAt(ptr) - 'a';
                    int v = s2.charAt(ptr) - 'a';
                    adj.get(u).add(v);  // u->v
                    break;
                }
            }
        }
    }
}
