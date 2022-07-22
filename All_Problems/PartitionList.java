// https://leetcode.com/problems/partition-list/
package All_Problems;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode list1 = new ListNode(0);   // this will store number less than x
        ListNode head1 = list1;
        ListNode list2 = new ListNode(0);   // this will store number greater than x
        ListNode head2 = list2;

        while (head != null) {
            if (head.val < x) {
                list1.next = head;
                list1 = list1.next;
            } else {
                list2.next = head;
                list2 = list2.next;
            }
            head = head.next;
        }

        list2.next = null;  // to avoid cycle in linked-list
        list1.next = head2.next;

        return head1.next;
    }
}
