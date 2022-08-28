// https://practice.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1
package LinkedList;

public class DeleteNodesHavingGreaterValueOnRight {

    public ListNode compute(ListNode head) {
        // your code here
        ListNode newHead = reverse(head);
        ListNode curr = newHead;
        int max = curr.val;
        while (curr.next != null) {
            while (curr.next != null && curr.next.val < max) {
                curr.next = curr.next.next;
            }
            if (curr.next == null) {
                break;
            }
            max = curr.next.val;
            curr = curr.next;
        }

        return reverse(newHead);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
