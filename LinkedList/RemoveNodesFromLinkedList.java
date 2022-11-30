// https://leetcode.com/problems/remove-nodes-from-linked-list/
package LinkedList;

public class RemoveNodesFromLinkedList {

    public static void main(String[] args) {
        int[] arr = {5, 2, 13, 3, 8};
        ListNode head = generateLinkedList(arr);

        ListNode ans = removeNodes(head);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }

    public static ListNode removeNodes(ListNode head) {
        ListNode rev = reverse(head);
        ListNode temp = rev;
        int max = rev.val;
        while (temp != null) {
            while (temp.next != null && temp.next.val < max) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
            if (temp != null) {
                max = Math.max(max, temp.val);
            }
        }

        return reverse(rev);
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
