// https://leetcode.com/problems/cheapest-flights-within-k-stops/
package All_Problems;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0, dst = 3, k = 1;
        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = generateGraph(flights, n);
        int[] distArr = new int[n];
        Arrays.fill(distArr, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();    // node, dist
        queue.add(new int[]{src, 0});
        int stops = 0;

        while (!queue.isEmpty() && stops <= k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                int node = temp[0];
                int dist = temp[1];

                for (int[] it : adj.get(node)) {
                    int neighbour = it[0];
                    int price = it[1];
                    if (dist + price < distArr[neighbour]) {
                        queue.add(new int[]{neighbour, dist + price});
                        distArr[neighbour] = dist + price;
                    }
                }
            }
            stops++;
        }

        return distArr[dst] != Integer.MAX_VALUE ? distArr[dst] : -1;
    }

    private static List<List<int[]>> generateGraph(int[][] flights, int n) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];
            adj.get(u).add(new int[]{v, price});
        }
        return adj;
    }
}
