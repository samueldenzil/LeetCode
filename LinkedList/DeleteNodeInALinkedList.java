// https://leetcode.com/problems/delete-node-in-a-linked-list/
package LinkedList;

public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        swap(node, node.next);
        node.next = node.next.next;
    }

    private void swap(ListNode n1, ListNode n2) {
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}
