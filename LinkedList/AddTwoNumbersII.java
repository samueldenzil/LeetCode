// https://leetcode.com/problems/add-two-numbers-ii/
package LinkedList;

import java.util.Stack;

public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stack1.add(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.add(l2.val);
                l2 = l2.next;
            }
        }

        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = 0;
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            sum += carry;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            carry = sum / 10;
        }
        if (carry != 0) {
            temp.next = new ListNode(carry);
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
