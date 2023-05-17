// https://leetcode.com/problems/swap-nodes-in-pairs/
package All_Problems;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode head = generateLinkedList(arr);

        ListNode ans = swapPairs(head);
        while (ans != null) {
            System.out.print(ans.val + " -> ");
            ans = ans.next;
        }
        System.out.println("null");
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head.next;
        head.next = swapPairs(head.next.next);
        temp.next = head;

        return temp;
    }

    private static ListNode generateLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        for (int it : arr) {
            temp.next = new ListNode(it);
            temp = temp.next;
        }
        return dummy.next;
    }
}
