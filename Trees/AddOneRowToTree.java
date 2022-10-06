// https://leetcode.com/problems/add-one-row-to-tree/
package Trees;

import java.util.Queue;
import java.util.LinkedList;

public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        int dp = 1;
        Queue<TreeNode> queue = new LinkedList<>();

        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (dp == depth - 1) {
                    TreeNode leftSubTree = node.left;
                    TreeNode rightSubTree = node.right;
                    node.left = new TreeNode(val);
                    node.right = new TreeNode(val);
                    node.left.left = leftSubTree;
                    node.right.right = rightSubTree;
                    // return root;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            dp++;
        }

        return root;
    }
}
