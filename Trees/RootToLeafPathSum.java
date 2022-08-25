// https://practice.geeksforgeeks.org/problems/root-to-leaf-path-sum/0
package Trees;

public class RootToLeafPathSum {

    public boolean hasPathSum(TreeNode root, int S) {
        // Your code here
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == S;
        }

        boolean left = hasPathSum(root.left, S - root.val);
        boolean right = false;
        if (!left) {
            right = hasPathSum(root.right, S - root.val);
        }
        return left || right;
    }
}
