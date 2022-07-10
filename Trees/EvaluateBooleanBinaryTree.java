// https://leetcode.com/problems/evaluate-boolean-binary-tree/
package Trees;

public class EvaluateBooleanBinaryTree {

    public static boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        return operation(left, right, root.val);
    }

    private static boolean operation(boolean val1, boolean val2, int task) {
        if (task == 2) {
            return val1 || val2;
        }
        return val1 && val2;
    }
}
