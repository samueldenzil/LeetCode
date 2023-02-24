// https://leetcode.com/problems/ipo/
package Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class IPO {

    public static void main(String[] args) {
        int k = 2, w = 0;
        int[] profits = {1, 2, 3}, capital = {0, 1, 1};
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = profits[i];
            projects[i][1] = capital[i];
        }

        Arrays.sort(projects, (a, b) -> (a[1] - b[1])); // sorting according to capital
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a)); // max heap
        int i = 0;
        while (k > 0) {
            while (i < n && projects[i][1] <= w) {
                pq.add(projects[i++][0]);
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
            }
            k--;
        }

        return w;
    }
}
