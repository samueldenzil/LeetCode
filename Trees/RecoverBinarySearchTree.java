// https://leetcode.com/problems/recover-binary-search-tree/
package Trees;

public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        recoverTree(root);
        traverse(root);
    }

    static TreeNode prev = null;
    static TreeNode first = null;
    static TreeNode end = null;

    public static void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = end.val;
        end.val = temp;
    }

    public static void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        if (prev != null) {
            if (root.val < prev.val) {
                if (first == null) {
                    first = prev;
                }
                end = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        System.out.print(root.val + " ");
        traverse(root.right);
    }
}
