// https://leetcode.com/problems/remove-linked-list-elements/
package LinkedList;

public class RemoveLinkedListElements {

    public ListNode removeElementsIterative(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;

        while (temp != null) {
            ListNode next = temp.next;
            while (next != null && next.val == val) {
                next = next.next;
            }
            temp.next = next;
            temp = temp.next;
        }

        return dummy.next;
    }

    public ListNode removeElementsRecursive(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElementsRecursive(head.next, val);
        if (head.val == val) {
            return head.next;
        }
        return head;
    }
}
