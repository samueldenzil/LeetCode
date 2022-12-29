// https://leetcode.com/problems/remove-stones-to-minimize-the-total/
package Heaps;

import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {

    public static void main(String[] args) {
        int[] piles = {4, 3, 6, 7};
        int k = 3;
        System.out.println(minStoneSum(piles, k));
    }

    // TC: O(nlogn) + O(klogn)
    // SC: O(n)
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a)); // max heap
        int sum = 0;

        for (int pile : piles) {
            pq.add(pile);
            sum += pile;
        }

        while (k > 0 && !pq.isEmpty()) {
            int largestElement = pq.poll();
            int remove = largestElement / 2;
            sum -= remove;
            pq.add(largestElement - remove);
            k--;
        }

        return sum;
    }
}
