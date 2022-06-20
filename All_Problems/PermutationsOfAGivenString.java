// https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
package All_Problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class PermutationsOfAGivenString {

    public static void main(String[] args) {
        String S = "ABC";
        System.out.println(find_permutation(S));
    }

    public static List<String> find_permutation(String S) {
        Set<String> set = new HashSet<>();
        boolean[] visited = new boolean[S.length()];

        helper(S, visited, set, "");
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    private static void helper(String S, boolean[] visited, Set<String> set, String curr) {
        // Base case
        if (curr.length() == S.length()) {
            set.add(curr);
            return;
        }

        for (int i = 0; i < S.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                helper(S, visited, set, curr + S.charAt(i));
                visited[i] = false;
            }
        }
    }
}
