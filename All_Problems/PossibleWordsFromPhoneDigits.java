// https://practice.geeksforgeeks.org/problems/possible-words-from-phone-digits-1587115620/1
package All_Problems;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class PossibleWordsFromPhoneDigits {

    public static void main(String[] args) {
        int[] a = {2, 3, 4};
        int N = 3;
        System.out.println(possibleWords(a, N));
    }

    public static ArrayList<String> possibleWords(int[] a, int N) {
        // your code here
        Map<Integer, char[]> map = generateMap();
        ArrayList<String> ans = new ArrayList<>();
        helper(0, a, N, ans, map, "");
        return ans;
    }

    private static void helper(int ind, int[] a, int N, ArrayList<String> ans, Map<Integer, char[]> map, String curr) {
        if (N == 0) {
            ans.add(curr);
            return;
        }
        char[] possibleChars = map.get(a[ind]);
        for (char c : possibleChars) {
            helper(ind + 1, a, N - 1, ans, map, curr + c);
        }
    }

    private static Map<Integer, char[]> generateMap() {
        Map<Integer, char[]> map = new HashMap<>();
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});
        return map;
    }
}
