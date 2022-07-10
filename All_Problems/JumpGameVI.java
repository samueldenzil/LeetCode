// https://leetcode.com/problems/jump-game-vi/
package All_Problems;

import java.util.PriorityQueue;

public class JumpGameVI {

    public static void main(String[] args) {
        int[] nums = {1, -1, -2, 4, -7, 3};
        int k = 2;

        System.out.println(maxResult(nums, k));
    }

    public static int maxResult(int[] nums, int k) {
        // Max Heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0])); // <score, index>

        pq.add(new int[]{nums[0], 0});

        int maxScore = nums[0];

        for (int i = 1; i < nums.length; i++) {
            while (!pq.isEmpty() && i - pq.peek()[1] > k) {
                pq.poll();
            }
            int[] curr = pq.peek();
            maxScore = nums[i] + curr[0];
            pq.add(new int[]{maxScore, i});
        }

        return maxScore;
    }
}
