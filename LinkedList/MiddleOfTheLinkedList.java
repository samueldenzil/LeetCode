// https://leetcode.com/problems/middle-of-the-linked-list/
package LinkedList;

public class MiddleOfTheLinkedList {

    public static ListNode middleNode(ListNode head) {
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
    }
}
