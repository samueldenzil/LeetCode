// https://leetcode.com/problems/delete-node-in-a-linked-list/
package All_Problems;

public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
