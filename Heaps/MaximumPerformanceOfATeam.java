// https://leetcode.com/problems/maximum-performance-of-a-team/
package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumPerformanceOfATeam {

    public static void main(String[] args) {
        int[] speed = {2, 10, 3, 1, 5, 8}, efficiency = {5, 4, 3, 9, 7, 2};
        int k = 2;
        System.out.println(maxPerformance(speed.length, speed, efficiency, k));
    }

    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];

        for (int i = 0; i < n; i++) {
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];
        }

        // sorting according to efficiency
        Arrays.sort(engineers, (a, b) -> (a[1] - b[1]));

        // Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (a - b));

        long sum = 0;
        long ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            sum += engineers[i][0];
            pq.add(engineers[i][0]);
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            ans = Math.max(ans, sum * engineers[i][1]);
        }

        return (int) (ans % 1000000007);
    }
}
