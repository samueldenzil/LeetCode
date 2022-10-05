// https://leetcode.com/problems/path-sum/
package Trees;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }

        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = false;
        if (!left) {
            right = hasPathSum(root.right, targetSum - root.val);
        }

        return left || right;
    }
}
