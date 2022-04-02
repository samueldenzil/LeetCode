// https://practice.geeksforgeeks.org/problems/move-all-zeros-to-the-front-of-the-linked-list/1
package LinkedList;

public class MoveAllZerosToTheFrontOfTheLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node moveZeroes(Node head) {
        //Your Code here.
        Node temp = head;

        while (temp != null) {
            while (temp.next != null && temp.next.data == 0) {
                Node zeroNode = temp.next;
                temp.next = temp.next.next;
                zeroNode.next = head;
                head = zeroNode;
            }
            temp = temp.next;
        }

        return head;
    }
}
