// https://leetcode.com/problems/sum-root-to-leaf-numbers/
package Trees;

public class SumRootToLeafNumbers {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        int[] ans = new int[1];
        helper(root, ans, 0);
        return ans[0];
    }

    private static void helper(TreeNode root, int[] ans, int curr) {
        if (root == null) {
            return;
        }
        // leaf node
        if (root.left == null && root.right == null) {
            ans[0] += (curr * 10) + root.val;
            return;
        }

        helper(root.left, ans, curr * 10 + root.val);
        helper(root.right, ans, curr * 10 + root.val);
    }
}
