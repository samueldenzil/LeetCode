// https://leetcode.com/problems/longest-path-with-different-adjacent-characters/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class LongestPathWithDifferentAdjacentCharacters {

    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 1, 2};
        String s = "abacbe";
        System.out.println(longestPath(parent, s));
    }

    public static int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> adj = generateTree(parent, n);
        int[] maxPath = new int[1];

        // System.out.println(adj);
        helper(0, -1, adj, s, maxPath);
        return maxPath[0];
    }

    private static int helper(int node, int parent, List<List<Integer>> adj, String s, int[] maxPath) {
        int longest = 0;
        int secondLongest = 0;

        for (int it : adj.get(node)) {
            if (it == parent) {
                continue;
            }

            int childLength = helper(it, node, adj, s, maxPath);
            if (s.charAt(node) == s.charAt(it)) {
                continue;
            }

            if (childLength > longest) {
                secondLongest = longest;
                longest = childLength;
            } else if (childLength > secondLongest) {
                secondLongest = childLength;
            }
        }
        maxPath[0] = Math.max(maxPath[0], longest + secondLongest + 1);
        return 1 + longest;
    }

    private static List<List<Integer>> generateTree(int[] parent, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int u = parent[i];
            int v = i;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
}
