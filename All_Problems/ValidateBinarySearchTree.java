// https://leetcode.com/problems/validate-binary-search-tree/
package All_Problems;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;

        return preorder(root, min, max);
    }

    private static boolean preorder(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        return (node.val > min && node.val < max && preorder(node.left, min, node.val) && preorder(node.right, node.val, max));
    }
}
