// https://leetcode.com/problems/reverse-nodes-in-k-group/
package LinkedList;

public class ReverseNodesInKGroup {

    // Recursive Solution
    // TC: O(n)
    // SC: O(n / k)
    public ListNode reverseKGroupRecursive(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode start = head;
        ListNode end = head;

        int inc = k - 1;
        while (inc > 0) {
            end = end.next;
            if (end == null) {
                return head;
            }
            inc--;
        }

        ListNode nextHead = reverseKGroupRecursive(end.next, k);
        reverse(start, end);
        start.next = nextHead;

        return end;
    }

    private void reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode curr = start;
        ListNode front = null;

        while (prev != end) {
            front = curr.next;
            curr.next = prev;

            prev = curr;
            curr = front;
        }
    }
}
