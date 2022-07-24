// https://leetcode.com/problems/middle-of-the-linked-list/
package All_Problems;

public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /* public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int n = 0;

        while (temp != null) {
            n++;
            temp = temp.next;
        }

        temp = head;
        int i = 0;
        while (i < n / 2) {
            temp = temp.next;
            i++;
        }

        return temp;
    } */
}
