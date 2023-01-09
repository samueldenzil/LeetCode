// https://leetcode.com/problems/maximal-score-after-applying-k-operations/
package All_Problems;

import java.util.PriorityQueue;

public class MaximalScoreAfterApplyingKOperations {

    public static void main(String[] args) {
        int[] nums = {10, 10, 10, 10, 10};
        int k = 5;
        System.out.println(maxKelements(nums, k));
    }

    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a)); // max heap
        long sum = 0;
        for (int it : nums) {
            pq.add(it);
        }
        while (k > 0) {
            int temp = pq.poll();
            sum += temp;
            int newNum = temp % 3 == 0 ? temp / 3 : temp / 3 + 1;
            pq.add(newNum);
            k--;
        }

        return sum;
    }
}
