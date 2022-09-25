// https://practice.geeksforgeeks.org/problems/mirror-tree/1
package Trees;

public class MirrorTree {

    public TreeNode mirror(TreeNode node) {
        // Your code here
        return helper(node);
    }

    private TreeNode helper(TreeNode node) {
        // base case
        if (node == null) {
            return null;
        }

        TreeNode leftSubtree = helper(node.left);
        TreeNode rightSubtree = helper(node.right);

        node.left = rightSubtree;
        node.right = leftSubtree;

        return node;
    }
}
