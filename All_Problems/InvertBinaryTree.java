// https://leetcode.com/problems/invert-binary-tree/
package All_Problems;

public class InvertBinaryTree {

    public static void main(String[] args) {
        String[] arr = {"4", "2", "7", "1", "3", "6", "9"};
        TreeNode root = generateTree(arr, 0);
        System.out.println(invertTree(root));
    }

    public static TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    private static void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        /* Here we can observe that
        -> the left subtree will come to the right side of the root
        -> the right subtree will come to the left side of the root
        -> the same is followed for their children */
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        helper(root.left);
        helper(root.right);
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
