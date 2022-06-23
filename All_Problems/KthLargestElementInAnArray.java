// https://leetcode.com/problems/kth-largest-element-in-an-array/
package All_Problems;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        // Min Heap
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);

        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }
}
