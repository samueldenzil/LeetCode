// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
package All_Problems;

import java.util.Queue;
import java.util.LinkedList;

public class MaximumLevelSumOfABinaryTree {

    public int maxLevelSum(TreeNode root) {
        int[] ans = new int[2]; // sum, level
        ans[0] = Integer.MIN_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (sum > ans[0]) {
                ans[0] = sum;
                ans[1] = level;
            }
            level++;
        }

        return ans[1];
    }
}
