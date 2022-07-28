// https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1
package All_Problems;

public class RotateALinkedList {

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 8, 9};
        Node head = generateLinkedList(arr);
        int k = 3;

        head = rotate(head, k);
        printLinkedList(head);
    }

    public static Node rotate(Node head, int k) {
        // add code here
        Node temp = head;
        while (k > 1) {
            temp = temp.next;
            k--;
        }

        Node newHead = temp.next;
        if (newHead == null) {
            return head;
        }
        temp.next = null;
        temp = newHead;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head;

        return newHead;
    }

    private static Node generateLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    private static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
