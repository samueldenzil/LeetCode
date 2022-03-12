// https://leetcode.com/problems/reverse-linked-list
package All_Problems;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(5);

        head = reverseListRecursive(temp);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("null");
    }

    public static ListNode reverseListRecursive(ListNode head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListIterative(head.next);
        ListNode headNext = head.next;
        headNext.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode reverseListIterative(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
