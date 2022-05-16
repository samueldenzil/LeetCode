// https://leetcode.com/problems/deepest-leaves-sum/
package Trees;

import java.util.Queue;
import java.util.LinkedList;

public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return sum;

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                sum += node.val;
            }
        }

        return sum;
    }
}
