// https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
package LinkedList;

public class AddTwoNumbersRepresentedByLinkedLists {

    public ListNode addTwoLists(ListNode first, ListNode second) {
        // code here
        // return head of sum list
        first = reverse(first);
        second = reverse(second);

        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (first != null && second != null) {
            int temp = first.val + second.val + carry;
            head.next = new ListNode(temp % 10);
            carry = temp / 10;
            first = first.next;
            second = second.next;
            head = head.next;
        }
        while (first != null) {
            int temp = first.val + carry;
            head.next = new ListNode(temp % 10);
            carry = temp / 10;
            first = first.next;
            head = head.next;
        }
        while (second != null) {
            int temp = second.val + carry;
            head.next = new ListNode(temp % 10);
            carry = temp / 10;
            second = second.next;
            head = head.next;
        }
        if (carry != 0) {
            head.next = new ListNode(carry);
        }

        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
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
}
