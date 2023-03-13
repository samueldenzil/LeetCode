// https://leetcode.com/problems/merge-k-sorted-lists/
package LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode[] lists = {
                generateLinkedList(new int[]{1, 4, 5}),
                generateLinkedList(new int[]{1, 3, 4}),
                generateLinkedList(new int[]{2, 6})
        };

        ListNode head = mergeKLists(lists);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    // TC: O(nlog(k))
    // SC: O(k)
    public static ListNode mergeKLists(ListNode[] lists) {
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

    private static ListNode generateLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        for (int it : arr) {
            temp.next = new ListNode(it);
            temp = temp.next;
        }
        return dummy.next;
    }
}
