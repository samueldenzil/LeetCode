// https://leetcode.com/problems/balanced-binary-tree/
package All_Problems;

public class BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public static int height(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeight = height(node.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = height(node.right);
        if (rightHeight == -1)
            return -1;

        // If the difference of height of the left and right subtree exceeds
        // 1 then, instead of returning the height of the tree return -1
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
