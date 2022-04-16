// https://leetcode.com/problems/binary-tree-preorder-traversal/
package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    // Iterative Approach
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> preorder = new ArrayList<>();

        // Edge case
        if (root == null) return preorder;

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);

            if (node.right != null)
                stack.add(node.right);
            if (node.left != null)
                stack.add(node.left);
        }

        return preorder;
    }

    // Recursive Approach
    /* public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        traverse(root, preorder);
        return preorder;
    }

    public void traverse(TreeNode node, List<Integer> preorder) {
        // Base case
        if (node == null) {
            return;
        }

        preorder.add(node.val);
        traverse(node.left, preorder);
        traverse(node.right, preorder);
    } */
}
