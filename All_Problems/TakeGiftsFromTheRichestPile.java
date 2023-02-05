// https://leetcode.com/problems/take-gifts-from-the-richest-pile/
package All_Problems;

import java.util.PriorityQueue;

public class TakeGiftsFromTheRichestPile {

    public static void main(String[] args) {
        int[] gifts = {25, 64, 9, 4, 100};
        int k = 4;
        System.out.println(pickGifts(gifts, k));
    }

    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a)); // max heap
        for (int gift : gifts) {
            pq.add(gift);
        }

        while (k > 0) {
            int gift = pq.poll();
            pq.add((int) Math.sqrt(gift));
            k--;
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
}
