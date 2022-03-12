// https://leetcode.com/problems/rotate-list/
package All_Problems;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        ListNode temp = head;
        int n = 0;

        // getting the last element and connecting it with the head
        while (temp.next != null) {
            temp = temp.next;
            n++;
        }

        temp.next = head;

        // splitting the list into two parts
        k = k % (n + 1);
        temp = head;
        int jumps = n - k;
        while (jumps > 0) {
            temp = temp.next;
            jumps--;
        }
        head = temp.next;
        temp.next = null;

        return head;
    }
}
