// https://leetcode.com/problems/merge-nodes-in-between-zeros/
package All_Problems;

public class MergeNodesInBetweenZeros {

    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        head = head.next;

        while (head != null) {
            if (head.val != 0) {
                sum += head.val;
            } else {
                temp.next = new ListNode(sum);
                temp = temp.next;
                sum = 0;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
