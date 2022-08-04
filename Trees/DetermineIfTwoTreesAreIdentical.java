// https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1
package Trees;

public class DetermineIfTwoTreesAreIdentical {

    boolean isIdentical(TreeNode root1, TreeNode root2) {
        // base case
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        boolean left = isIdentical(root1.left, root2.left);
        if (!left) {
            return false;
        }
        boolean right = isIdentical(root1.right, root2.right);
        return right;
    }
}
