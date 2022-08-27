// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
package LinkedList;

public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }

    private TreeNode helper(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }
        ListNode fast = start;
        ListNode slow = start;

        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = helper(start, slow);
        root.right = helper(slow.next, end);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
