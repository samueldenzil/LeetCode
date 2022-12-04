// https://leetcode.com/problems/sort-characters-by-frequency/
package All_Problems;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (b.count - a.count));    // max heap
        for (char c : map.keySet()) {
            pq.add(new Pair(c, map.get(c)));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            while (p.count > 0) {
                sb.append(p.ch);
                p.count--;
            }
        }
        return sb.toString();
    }

    static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
