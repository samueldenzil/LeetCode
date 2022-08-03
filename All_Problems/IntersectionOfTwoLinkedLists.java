// https://leetcode.com/problems/intersection-of-two-linked-lists
package All_Problems;

import java.util.Set;
import java.util.HashSet;

public class IntersectionOfTwoLinkedLists {

    // TC: O(n + m)
    // SC: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }

            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }

        return a;
    }


    // TC: O(n + m)
    // SC: O(1)
    /* public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        int len1 = 0;
        int len2 = 0;

        while (tempA != null) {
            len1++;
            tempA = tempA.next;
        }

        while (tempB != null) {
            len2++;
            tempB = tempB.next;
        }

        tempA = headA;
        tempB = headB;
        while (len1 > len2) {
            tempA = tempA.next;
            len1--;
        }
        while (len1 < len2) {
            tempB = tempB.next;
            len2--;
        }

        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return tempA;
    } */


    // TC: O(n + m)
    // SC: O(n)
    /* public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    } */
}
