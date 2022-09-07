// https://leetcode.com/problems/binary-tree-pruning/
package Trees;

public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        return helper(root) ? root : null;
    }

    private boolean helper(TreeNode root) {
        if (root == null) {
            return false;
        }
        // Check left subtree contains a 1
        boolean left = helper(root.left);
        // Check right subtree contains a 1
        boolean right = helper(root.right);

        // If not then prune the tree
        if (!left) {
            root.left = null;
        }
        if (!right) {
            root.right = null;
        }

        // Return true if the current node, left or right subtree contains a 1
        return root.val == 1 || left || right;
    }
}
