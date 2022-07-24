// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
package All_Problems;

public class ConvertBinaryNumberInALinkedListToInteger {

    public int getDecimalValue(ListNode head) {
        int ans = 0;
        ListNode temp = head;

        while (temp != null) {
            ans *= 2;           // we found that there is a new node
            ans += temp.val;    // 2^0 = 1
            temp = temp.next;
        }

        return ans;
    }

    /* public int getDecimalValue(ListNode head) {
        int n = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            n++;
        }

        int pow = n - 1;
        int ans = 0;
        temp = head;
        while (temp != null) {
            ans += (temp.val * Math.pow(2, pow));
            pow--;
            temp = temp.next;
        }

        return ans;
    } */
}
