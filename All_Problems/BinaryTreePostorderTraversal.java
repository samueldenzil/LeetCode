// https://leetcode.com/problems/binary-tree-postorder-traversal/
package All_Problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    // Iterative Approach
    public static List<Integer> postorderTraversal(TreeNode root) {
        // Using 2 Stacks
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> postorder = new ArrayList<>();

        // Base case
        if (root == null)
            return postorder;

        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
            stack2.add(node);
        }

        while (!stack2.isEmpty()) {
            postorder.add(stack2.pop().val);
        }

        return postorder;
    }

    // Recursive Approach
    /* public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        traverse(root, postorder);
        return postorder;
    }

    public static void traverse(TreeNode node, List<Integer> postorder) {
        // Base case
        if (node == null) {
            return;
        }

        // left, right, root
        traverse(node.left, postorder);
        traverse(node.right, postorder);
        postorder.add(node.val);
    } */
}
