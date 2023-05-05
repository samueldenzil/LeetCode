// https://leetcode.com/problems/dota2-senate/
package All_Problems;

import java.util.Queue;
import java.util.LinkedList;

public class Dota2Senate {

    public static void main(String[] args) {
        String senate = "RD";
        System.out.println(predictPartyVictory(senate));
    }

    public static String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.add(i);
            } else {
                direQueue.add(i);
            }
        }

        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            int rIdx = radiantQueue.poll();
            int dIdx = direQueue.poll();
            if (rIdx < dIdx) {
                radiantQueue.add(rIdx + n);
            } else {
                direQueue.add(dIdx + n);
            }
        }

        return radiantQueue.size() > direQueue.size() ? "Radiant" : "Dire";
    }
}
