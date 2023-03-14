// https://leetcode.com/problems/symmetric-tree/
package All_Problems;

public class SymmetricTree {

    public static void main(String[] args) {
        String[] arr = {"1", "2", "2", "3", "4", "4", "3"};
        TreeNode root = generateTree(arr, 0);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    private static boolean helper(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }

        return l.val == r.val && helper(l.left, r.right) && helper(l.right, r.left);
    }

    private static TreeNode generateTree(String[] arr, int i) {
        TreeNode root = null;
        if (i < arr.length && arr[i] != null) {
            root = new TreeNode(Integer.parseInt(arr[i]));
            root.left = generateTree(arr, i * 2 + 1);
            root.right = generateTree(arr, i * 2 + 2);
        }
        return root;
    }
}
