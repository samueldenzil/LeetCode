// https://leetcode.com/problems/add-two-numbers
package LinkedList;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode temp = ans;

        int carry = 0;

        while (l1 != null || l2 != null) {
            temp.next = new ListNode(0);
            temp = temp.next;

            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            temp.val = sum % 10;
            carry = sum / 10;
        }

        if (carry != 0) {
            temp.next = new ListNode(carry);
        }

        return ans.next;
    }
}
