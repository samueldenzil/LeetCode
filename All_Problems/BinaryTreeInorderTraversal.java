// https://leetcode.com/problems/binary-tree-inorder-traversal/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class BinaryTreeInorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
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
    }
}
