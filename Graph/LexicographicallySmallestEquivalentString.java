// https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
package Graph;

import java.util.List;
import java.util.ArrayList;

public class LexicographicallySmallestEquivalentString {

    public static void main(String[] args) {
        String s1 = "parker", s2 = "morris", baseStr = "parser";
        System.out.println(smallestEquivalentString(s1, s2, baseStr));
    }

    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        List<List<Integer>> adj = generateGraph(s1, s2);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < baseStr.length(); i++) {
            char c = baseStr.charAt(i);
            boolean[] vis = new boolean[26];
            sb.append(helper(c, adj, vis));
        }

        return sb.toString();
    }

    private static char helper(char c, List<List<Integer>> adj, boolean[] vis) {
        vis[c - 'a'] = true;
        char minChar = c;

        for (int it : adj.get(c - 'a')) {
            if (!vis[it]) {
                char curr = helper((char) (it + 'a'), adj, vis);
                if (curr - 'a' < minChar - 'a') {
                    minChar = curr;
                }
            }
        }
        return minChar;
    }

    private static List<List<Integer>> generateGraph(String s1, String s2) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < s1.length(); i++) {
            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
}
