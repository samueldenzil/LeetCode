// https://leetcode.com/problems/odd-string-difference
package Arrays;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class OddStringDifference {

    public static void main(String[] args) {
        String[] words = {"adc", "wzy", "abc"};
        System.out.println(oddString(words));
    }

    public static String oddString(String[] words) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            String difference = getDifference(word);
            if (!map.containsKey(difference)) {
                map.put(difference, new ArrayList<>());
            }
            map.get(difference).add(word);
        }

        for (String word : map.keySet()) {
            if (map.get(word).size() == 1) {
                return map.get(word).get(0);
            }
        }

        return "";
    }

    private static String getDifference(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < word.length(); i++) {
            char c1 = word.charAt(i - 1);
            char c2 = word.charAt(i);
            sb.append(c1 - c2);
            sb.append(" ");
        }
        return sb.toString();
    }
}
