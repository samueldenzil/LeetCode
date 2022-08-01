// https://practice.geeksforgeeks.org/problems/sum-tree/1
package Trees;

public class SumTree {

    boolean ans = true;

    public boolean isSumTree(TreeNode root) {
        helper(root);
        return ans;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int left = helper(root.left);
        int right = helper(root.right);
        if (root.val != left + right) {
            ans = false;
        }
        return root.val + left + right;
    }
}
