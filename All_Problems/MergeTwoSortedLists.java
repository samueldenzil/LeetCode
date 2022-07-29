// https://leetcode.com/problems/merge-two-sorted-lists/

package All_Problems;

class MergeTwoSortedLists {

    // Iterative Approach
    public ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode handler = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                handler.next = list1;
                list1 = list1.next;
            } else {
                handler.next = list2;
                list2 = list2.next;
            }
            handler = handler.next;
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

    // Recursive Approach
    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
    }
}