// https://leetcode.com/problems/merge-k-sorted-lists/
package LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    // TC: O(nlog(k))
    // SC: O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        // Min Heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));

        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode itr = dummy;

        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            itr.next = temp;
            itr = itr.next;
            if (temp.next != null) {
                pq.add(temp.next);
            }
        }

        return dummy.next;
    }
}
