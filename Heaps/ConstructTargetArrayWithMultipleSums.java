// https://leetcode.com/problems/construct-target-array-with-multiple-sums/
package Heaps;

import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums {

    public static void main(String[] args) {
        int[] target = {9, 3, 5};
        System.out.println(isPossible(target));
    }

    public static boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a)); // MAX heap
        long totalSum = 0;

        for (int el : target) {
            pq.add(el);
            totalSum = totalSum + el;
        }

        while (!pq.isEmpty()) {
            int maxElement = pq.poll();
            long remainingSum = totalSum - maxElement;

            if (maxElement == 1 || remainingSum == 1) {
                return true;
            }
            if (remainingSum == 0 || maxElement < remainingSum) {
                return false;
            }

            int newElement = (int) (maxElement % remainingSum);

            if (newElement == 0) {
                return false;
            }

            maxElement = newElement;
            pq.offer(maxElement);
            totalSum = newElement + remainingSum;
        }

        return true;
    }
}
