// https://leetcode.com/problems/maximum-depth-of-binary-tree
package Trees;

import java.util.Queue;
import java.util.LinkedList;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        String[] arr = {"3", "9", "20", null, null, "15", "7"};
        TreeNode root = generateTree(arr, 0);
        System.out.println(maxDepth(root));
    }

    // Recursive Approach
    public static int maxDepth(TreeNode root) {
        // Base case
        if (root == null) {
            return 0;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Level order traversal
    /* public static int maxDepth(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return depth;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            int length = queue.size();

            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            depth++;
        }

        return depth;
    } */

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
