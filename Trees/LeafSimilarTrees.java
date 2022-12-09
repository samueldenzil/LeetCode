// https://leetcode.com/problems/leaf-similar-trees/
package Trees;

public class LeafSimilarTrees {

    public static void main(String[] args) {
        int[] arr1 = {3, 5, 1, 6, 2, 9, 8, -1, -1, 7, 4};
        int[] arr2 = {3, 5, 1, 6, 7, 4, 2, -1, -1, -1, -1, -1, -1, 9, 8};
        TreeNode root1 = generateTree(arr1, 0);
        TreeNode root2 = generateTree(arr2, 0);

        System.out.println(leafSimilar(root1, root2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        inorder(root1, sb1);
        inorder(root2, sb2);

        return sb1.toString().equals(sb2.toString());
    }

    private static void inorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            sb.append("_");
            return;
        }
        inorder(root.left, sb);
        inorder(root.right, sb);
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
