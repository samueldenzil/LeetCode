// https://leetcode.com/problems/kth-largest-element-in-a-stream/
package All_Problems;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    public PriorityQueue<Integer> list = new PriorityQueue<>((a, b) -> a - b);
    public int size = 0;

    public KthLargestElementInAStream(int k, int[] nums) {
        size = k;

        for (int num : nums) {
            list.add(num);
            if (list.size() > size) {
                list.poll();
            }
        }
    }

    public int add(int val) {
        list.add(val);
        if (list.size() > size) {
            list.poll();
        }
        return list.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAStream kthLargest = new KthLargestElementInAStream(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }
}
