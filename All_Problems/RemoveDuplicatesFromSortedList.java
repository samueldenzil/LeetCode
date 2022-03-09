// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
package All_Problems;

public class RemoveDuplicatesFromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode temp = head;
        ListNode prev = dummy;

        while (temp != null) {
            if (temp.next != null && temp.val == temp.next.val) {
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
            }
            prev.next = temp;
            prev = prev.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}
