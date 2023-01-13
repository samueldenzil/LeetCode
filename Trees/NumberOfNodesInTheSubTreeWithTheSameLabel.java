// https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
package Trees;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class NumberOfNodesInTheSubTreeWithTheSameLabel {

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        String labels = "abaedcd";
        System.out.println(Arrays.toString(countSubTrees(n, edges, labels)));
    }

    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj = generateTree(edges, n);
        int[] ans = new int[n];
        dfs(0, -1, labels, adj, n, ans);
        return ans;
    }

    private static int[] dfs(int node, int parent, String labels, List<List<Integer>> adj, int n, int[] ans) {
        int[] currArr = new int[26];
        for (int it : adj.get(node)) {
            if (it == parent) {
                continue;
            }

            int[] childArr = dfs(it, node, labels, adj, n, ans);
            for (int i = 0; i < 26; i++) {
                currArr[i] += childArr[i];
            }
        }
        int currIdx = labels.charAt(node) - 'a';
        currArr[currIdx]++;
        // System.out.println(node + " " + Arrays.toString(currArr));
        ans[node] = currArr[currIdx];
        return currArr;
    }

    private static List<List<Integer>> generateTree(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
}
