// https://leetcode.com/problems/merge-two-sorted-lists/

package All_Problems;

class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode handler = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                handler.next = list1;
                list1 = list1.next;
                handler = handler.next;
            } else {
                handler.next = list2;
                list2 = list2.next;
                handler = handler.next;
            }
        }

        while (list1 != null) {
            handler.next = list1;
            list1 = list1.next;
            handler = handler.next;
        }

        while (list2 != null) {
            handler.next = list2;
            list2 = list2.next;
            handler = handler.next;
        }

        return head.next;
    }
}