// https://leetcode.com/problems/middle-of-the-linked-list/
package LinkedList;

public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = generateLinkedList(arr);

        ListNode ans = middleNode(head);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
