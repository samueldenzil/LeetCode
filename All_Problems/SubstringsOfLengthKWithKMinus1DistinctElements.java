// https://practice.geeksforgeeks.org/problems/substrings-of-length-k-with-k-1-distinct-elements/1
package All_Problems;

import java.util.Map;
import java.util.HashMap;

public class SubstringsOfLengthKWithKMinus1DistinctElements {

    public static void main(String[] args) {
        String S = "aabab";
        int K = 3;
        System.out.println(countOfSubstrings(S, K));
    }

    public static int countOfSubstrings(String S, int K) {
        // code here
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < K; i++) {
            char c = S.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        if (map.size() == K - 1) {
            ans++;
        }

        for (int i = K; i < S.length(); i++) {
            char c1 = S.charAt(i - K);
            map.put(c1, map.get(c1) - 1);
            if (map.get(c1) == 0) {
                map.remove(c1);
            }
            char c2 = S.charAt(i);
            if (!map.containsKey(c2)) {
                map.put(c2, 0);
            }
            map.put(c2, map.get(c2) + 1);
            if (map.size() == K - 1) {
                ans++;
            }
        }

        return ans;
    }
}
