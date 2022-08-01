// https://leetcode.com/problems/linked-list-cycle/
package All_Problems;

import java.util.Set;
import java.util.HashSet;

public class LinkedListCycle {

    // Optimized Approach
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }


    // Naive Approach
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }

        return false;
    }
}
