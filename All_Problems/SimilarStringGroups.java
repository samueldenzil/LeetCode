// https://leetcode.com/problems/similar-string-groups/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class SimilarStringGroups {

    public static void main(String[] args) {
        String[] strs = {"tars", "rats", "arts", "star"};
        System.out.println(numSimilarGroups(strs));
    }

    public static int numSimilarGroups(String[] strs) {
        int n = strs.length;
        List<List<Integer>> adj = new ArrayList<>();
        generateGraph(adj, strs, n);

        boolean[] vis = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis);
                count++;
            }
        }

        return count;
    }

    private static void dfs(int idx, List<List<Integer>> adj, boolean[] vis) {
        vis[idx] = true;

        for (int it : adj.get(idx)) {
            if (!vis[it]) {
                dfs(it, adj, vis);
            }
        }
    }

    private static void generateGraph(List<List<Integer>> adj, String[] strs, int n) {
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int u = 0; u < n; u++) {
            for (int v = u + 1; v < n; v++) {
                if (isSimilar(strs[u], strs[v])) {
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
            }
        }
    }

    private static boolean isSimilar(String s1, String s2) {
        int mismatchedChars = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                mismatchedChars++;
            }
        }
        return mismatchedChars == 2 || mismatchedChars == 0;
    }
}
