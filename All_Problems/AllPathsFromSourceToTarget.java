// https://leetcode.com/problems/all-paths-from-source-to-target/
package All_Problems;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(allPathsSourceTarget(graph));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, graph, ans, new ArrayList<>());
        return ans;
    }

    // DFS Solution
    private static void helper(int node, int[][] graph, List<List<Integer>> ans, List<Integer> curr) {
        curr.add(node);

        // base case
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(curr));
            curr.remove(curr.size() - 1);
            return;
        }

        for (int it : graph[node]) {
            helper(it, graph, ans, curr);
        }

        curr.remove(curr.size() - 1);
    }


    // BFS Solution
    /* public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int startNode = 0;
        int endNode = graph.length - 1;
        List<List<Integer>> ans = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();

        queue.add(Arrays.asList(startNode));

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = queue.poll();
            int lastNode = list.get(list.size() - 1);
            if (lastNode == endNode) {
                ans.add(list);
            }

            for (int it : graph[lastNode]) {
                List<Integer> copyList = new ArrayList<>(list);
                copyList.add(it);
                queue.add(copyList);
            }
        }

        return ans;
    } */
}
