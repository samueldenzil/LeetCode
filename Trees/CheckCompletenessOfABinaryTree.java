// https://leetcode.com/problems/check-completeness-of-a-binary-tree/
package Trees;

import java.util.Queue;
import java.util.LinkedList;

public class CheckCompletenessOfABinaryTree {

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "5", "6"};
        TreeNode root = generateTree(arr, 0);
        System.out.println(isCompleteTree(root));
    }

    public static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean past = false;
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    past = true;
                    continue;
                }

                if (past) {
                    return false;
                }

                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return true;
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
