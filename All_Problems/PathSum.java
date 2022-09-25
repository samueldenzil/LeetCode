// https://leetcode.com/problems/path-sum/
package All_Problems;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        // edge case
        if (root == null) {
            return false;
        }
        return helper(root, targetSum);
    }

    private boolean helper(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        // if curr node is the leaf node
        if (root.left == null && root.right == null) {
            return root.val - target == 0;
        }

        boolean left = helper(root.left, target - root.val);
        boolean right = false;
        if (!left) {
            right = helper(root.right, target - root.val);
        }

        return left || right;
    }
}
