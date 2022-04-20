// https://leetcode.com/problems/odd-even-linked-list/
package LinkedList;

public class OddEvenLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(5);
        temp = oddEvenList(temp);

        while (temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        else if (head.next == null)
            return head;

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
}
