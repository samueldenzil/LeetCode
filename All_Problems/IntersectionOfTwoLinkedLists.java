// https://leetcode.com/problems/intersection-of-two-linked-lists
package All_Problems;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoLinkedLists {

    private static void generateLinkedList(ListNode head, int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            head.next = new ListNode(arr[i]);
            head = head.next;
        }
    }

    // TC: O(n + m)
    // SC: O(1)
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
    }


    // TC: O(n + m)
    // SC: O(n)
    /* public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        List<ListNode> list = new ArrayList<>();

        while (tempA != null) {
            list.add(tempA);
            tempA = tempA.next;
        }

        while (tempB != null) {
            if (list.contains(tempB)) {
                return tempB;
            }
            tempB = tempB.next;
        }

        return null;
    } */
}
