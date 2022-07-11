// https://practice.geeksforgeeks.org/problems/polynomial-addition/1
package LinkedList;

public class PolynomialAddition {
    static class Node {
        int coeff;
        int pow;
        Node next;

        Node(int a, int b) {
            coeff = a;
            pow = b;
            next = null;
        }
    }

    public static Node addPolynomial(Node p1, Node p2) {
        //Add your code here.
        Node head = new Node(0, 0);
        Node temp = head;

        while (p1 != null && p2 != null) {
            if (p1.pow == p2.pow) {
                temp.next = new Node(p1.coeff + p2.coeff, p1.pow);
                p1 = p1.next;
                p2 = p2.next;
            } else if (p1.pow > p2.pow) {
                temp.next = new Node(p1.coeff, p1.pow);
                p1 = p1.next;
            } else {
                temp.next = new Node(p2.coeff, p2.pow);
                p2 = p2.next;
            }
            temp = temp.next;
        }

        if (p1 != null) {
            temp.next = p1;
        } else {
            temp.next = p2;
        }

        return head.next;
    }
}
