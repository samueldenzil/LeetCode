// https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1#
package All_Problems;

import java.util.PriorityQueue;

public class KthSmallestElement {

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(kthSmallest(arr, k));
    }

    static PriorityQueue<Integer> pq;

    public static int kthSmallest(int[] arr, int k) {
        //Your code here
        pq = new PriorityQueue<>((a, b) -> b - a);  // Max Heap
        for (int num : arr) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.size() != 0 ? pq.poll() : -1;
    }
}