// https://practice.geeksforgeeks.org/problems/reorder-list/1
package All_Problems;

public class ReorderList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = generateLinkedList(arr);

        ListNode ans = reorderlist(head);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }

    public static ListNode reorderlist(ListNode head) {
        // Your code here
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode list1 = head;
        ListNode list2 = reverse(slow.next);
        slow.next = null;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (list1 != null || list2 != null) {
            if (list1 != null) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }

            if (list2 != null) {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }

        return dummy.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static ListNode generateLinkedList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }
}
