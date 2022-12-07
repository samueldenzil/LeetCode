// https://leetcode.com/problems/odd-even-linked-list/
package All_Problems;

public class OddEvenLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = generateLinkedList(arr);

        ListNode ans = oddEvenList(head);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode odd = new ListNode(0);
        ListNode oddTemp = odd;
        ListNode even = new ListNode(0);
        ListNode evenTemp = even;

        while (head != null && head.next != null) {
            odd.next = head;
            odd = odd.next;
            even.next = head.next;
            even = even.next;
            head = head.next.next;
        }
        if (head != null) {
            odd.next = head;
            odd = odd.next;
        }
        odd.next = evenTemp.next;
        even.next = null;
        return oddTemp.next;
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
