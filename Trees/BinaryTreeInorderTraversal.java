// https://leetcode.com/problems/binary-tree-inorder-traversal/
package Trees;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    // Iterative Approach
    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> inorder = new ArrayList<>();

        // Base case
        if (root == null) return inorder;

        TreeNode node = root;

        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty())
                    break;
                node = stack.pop();
                inorder.add(node.val);
                node = node.right;
            }
        }

        return inorder;
    }

    // Recursive Approach
    /* public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        traverse(root, inorder);
        return inorder;
    }

    public static void traverse(TreeNode node, List<Integer> inorder) {
        // Base case
        if (node == null) {
            return;
        }

        // left, root, right
        traverse(node.left, inorder);
        inorder.add(node.val);
        traverse(node.right, inorder);
    } */
}
