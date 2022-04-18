// https://leetcode.com/problems/increasing-order-search-tree/
package Trees;

public class IncreasingOrderSearchTree {

    TreeNode temp = new TreeNode(-1);
    TreeNode dummy = temp;

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return dummy.right;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        temp.right = root;
        root.left = null;
        temp = temp.right;
        inorder(root.right);
    }
}
