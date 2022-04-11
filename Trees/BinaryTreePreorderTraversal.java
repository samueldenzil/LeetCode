// https://leetcode.com/problems/binary-tree-preorder-traversal/
package Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
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
    }
}
