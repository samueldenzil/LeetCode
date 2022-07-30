// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
package LinkedList;

public class RemoveDuplicatesFromSortedList {

    // Iterative Approach
    // TC: O(n)
    // SC: O(1)
    public static ListNode deleteDuplicatesIterative(ListNode head) {
        ListNode temp = head;
        if (head == null) {
            return null;
        }

        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }


    // Recursive Approach
    // TC: O(n)
    // SC: O(n)
    public ListNode deleteDuplicatesRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = deleteDuplicatesRecursive(head.next);

        if (head.val == newHead.val) {
            return newHead;
        }

        head.next = newHead;
        return head;
    }
}
