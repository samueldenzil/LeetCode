// https://leetcode.com/problems/range-sum-of-bst/
package All_Problems;

public class RangeSumOfBST {

    public static void main(String[] args) {
        int[] arr = {10, 5, 15, 3, 7, -1, 18};
        TreeNode root = generateBinaryTree(arr, 0);
        int low = 7, high = 15;

        System.out.println(rangeSumBST(root, low, high));
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        // root.val > high
        return rangeSumBST(root.left, low, high);
    }

    private static TreeNode generateBinaryTree(int[] arr, int i) {
        TreeNode root = null;
        // Base case for recursion

        if (i < arr.length && arr[i] != -1) {
            root = new TreeNode(arr[i]);

            // insert left child
            root.left = generateBinaryTree(arr, 2 * i + 1);

            // insert right child
            root.right = generateBinaryTree(arr, 2 * i + 2);
        }

        return root;
    }
}
