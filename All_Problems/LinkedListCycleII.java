// https://leetcode.com/problems/linked-list-cycle-ii/
package All_Problems;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

    // Optimized Approach
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        // if there is no cycle
        if (fast == null || fast.next == null) {
            return null;
        }

        ListNode ptr1 = head;
        ListNode ptr2 = slow;

        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }


    // Naive Approach
    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }

        return null;
    }
}
