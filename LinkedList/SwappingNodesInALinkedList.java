// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
package LinkedList;

public class SwappingNodesInALinkedList {

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;

        int i = 1;
        while (i != k) {
            p1 = p1.next;
            i++;
        }

        ListNode nthNode = p1;

        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        int temp = nthNode.val;
        nthNode.val = p2.val;
        p2.val = temp;

        return head;
    }
}
