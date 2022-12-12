// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
package All_Problems;

public class MaximumProductOfSplittedBinaryTree {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        TreeNode root = generateTree(arr, 0);
        System.out.println(maxProduct(root));
    }

    private static long totalSum = 0;
    private static long maxProduct = 0;
    private static int MOD = (int) 1e9 + 7;

    public static int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root);
        getTotalSum(root);
        return (int) (maxProduct % MOD);
    }

    private static int getTotalSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftChild = getTotalSum(root.left);
        int rightChild = getTotalSum(root.right);

        long s1 = root.val + leftChild + rightChild;
        long s2 = totalSum - s1;
        maxProduct = Math.max(maxProduct, s1 * s2);

        return (int) s1;
    }

    private static TreeNode generateTree(int[] arr, int i) {
        TreeNode root = null;
        if (i < arr.length && arr[i] != -1) {
            root = new TreeNode(arr[i]);

            root.left = generateTree(arr, i * 2 + 1);
            root.right = generateTree(arr, i * 2 + 2);
        }
        return root;
    }
}
