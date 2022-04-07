// https://leetcode.com/problems/remove-nth-node-from-end-of-list
package LinkedList;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(2);
        temp = removeNthFromEnd(head, 1);

        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;

        int i = 1;

        while (i <= n) {
            if (p1.next == null) {
                head = head.next;
                return head;
            }
            p1 = p1.next;
            i++;
        }

        p1 = p1.next;

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;

        return head;
    }
}
