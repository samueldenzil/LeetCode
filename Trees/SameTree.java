// https://leetcode.com/problems/same-tree/
package Trees;

public class SameTree {

    public static void main(String[] args) {
        String[] arr1 = {"1", "2", "3"};
        String[] arr2 = {"1", "2", "3"};
        TreeNode p = generateTree(arr1, 0);
        TreeNode q = generateTree(arr2, 0);
        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case
        if (p == null || q == null) {
            return (p == q);
        }

        return isSameTree(p.left, q.left) && (p.val == q.val) && isSameTree(p.right, q.right);
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
