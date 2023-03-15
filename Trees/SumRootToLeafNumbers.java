// https://leetcode.com/problems/sum-root-to-leaf-numbers/
package Trees;

public class SumRootToLeafNumbers {

    public static void main(String[] args) {
        String[] arr = {"4", "9", "0", "5", "1"};
        TreeNode root = generateTree(arr, 0);
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        int[] ans = new int[1];
        helper(root, 0, ans);
        return ans[0];
    }

    private static void helper(TreeNode root, int currSum, int[] ans) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {  // leaf node
            ans[0] += currSum * 10 + root.val;
            return;
        }
        helper(root.left, currSum * 10 + root.val, ans);
        helper(root.right, currSum * 10 + root.val, ans);
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
