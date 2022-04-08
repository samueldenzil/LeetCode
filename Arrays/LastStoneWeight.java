// https://leetcode.com/problems/last-stone-weight/
package Arrays;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() != 0) {
            if (pq.size() == 0 || pq.size() == 1)
                break;

            int y = pq.poll();
            int x = pq.poll();

            if (x != y) {
                pq.add(y - x);
            }
        }

        return pq.size() != 0 ? pq.poll() : 0;
    }
}
