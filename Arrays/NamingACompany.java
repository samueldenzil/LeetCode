// https://leetcode.com/problems/naming-a-company/
package Arrays;

import java.util.HashSet;

public class NamingACompany {

    public static void main(String[] args) {
        String[] ideas = {"coffee", "donuts", "time", "toffee"};
        System.out.println(distinctNames(ideas));
    }

    public static long distinctNames(String[] ideas) {
        HashSet<String>[] map = new HashSet[26];    // first char, suffix

        for (String idea : ideas) {
            char firstChar = idea.charAt(0);
            if (map[firstChar - 'a'] == null) {
                map[firstChar - 'a'] = new HashSet<>();
            }
            map[firstChar - 'a'].add(idea.substring(1));
        }

        long ans = 0;
        for (int char1 = 0; char1 < 26; char1++) {
            if (map[char1] == null) {
                continue;
            }

            for (int char2 = char1 + 1; char2 < 26; char2++) {
                if (map[char2] == null) {
                    continue;
                }

                int intersection = 0;
                for (String w : map[char1]) {
                    if (map[char2].contains(w)) {
                        intersection++;
                    }
                }

                int distinctInChar1 = map[char1].size() - intersection;
                int distinctInChar2 = map[char2].size() - intersection;
                ans += ((long) distinctInChar1 * distinctInChar2 * 2);
            }
        }

        return ans;
    }
}
