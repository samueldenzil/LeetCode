// https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
package Heaps;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {

    public static void main(String[] args) {
        long[] arr = {4, 2, 7, 6, 9};
        int n = arr.length;
        System.out.println(minCost(arr,n));
    }

    public static long minCost(long[] arr, int n) {
        // your code here
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (long it : arr) {
            pq.add(it);
        }

        long cost = 0;
        while (pq.size() > 1) {
            long num1 = pq.poll();
            long num2 = pq.poll();
            long sum = num1 + num2;
            cost += sum;
            pq.add(sum);
        }

        return cost;
    }
}
