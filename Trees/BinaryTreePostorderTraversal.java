// https://leetcode.com/problems/binary-tree-postorder-traversal/
package Trees;

import java.util.List;
import java.util.ArrayList;

public class BinaryTreePostorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
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
    }
}
