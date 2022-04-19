// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
package All_Problems;

import java.util.PriorityQueue;
import java.util.Stack;

public class KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                root = stack.pop();
                if (--k == 0) {
                    return root.val;
                }
                root = root.right;
            }
        }

        return -1;
    }

    /* Hint:
        To find kth smallest -> use max heap
        To find kth largest -> use min heap */

    // Max Heap
    /* static PriorityQueue<Integer> queue;

    public static int kthSmallest(TreeNode root, int k) {
        queue = new PriorityQueue<>((a, b) -> b - a);
        inorder(root, k);
        return queue.peek();
    }

    public static void inorder(TreeNode node, int k) {
        // Base Case
        if (node == null)
            return;

        inorder(node.left, k);
        queue.add(node.val);
        if (queue.size() > k) {
            queue.poll();
        }
        inorder(node.right, k);
    } */
}
