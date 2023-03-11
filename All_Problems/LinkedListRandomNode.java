// https://leetcode.com/problems/linked-list-random-node/
package All_Problems;

import java.util.Random;

public class LinkedListRandomNode {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ListNode head = generateLinkedList(arr);

        LinkedListRandomNode linkedListRandomNode = new LinkedListRandomNode(head);
        System.out.println(linkedListRandomNode.getRandom());
        System.out.println(linkedListRandomNode.getRandom());
        System.out.println(linkedListRandomNode.getRandom());
        System.out.println(linkedListRandomNode.getRandom());
        System.out.println(linkedListRandomNode.getRandom());
    }

    private ListNode head;
    private Random rand;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        rand = new Random();
    }

    public int getRandom() {
        int res = -1;
        ListNode t = head;
        for (int i = 1; t != null; i++) {
            if (rand.nextInt(i) == i - 1) {
                res = t.val;
            }
            t = t.next;
        }
        return res;
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
