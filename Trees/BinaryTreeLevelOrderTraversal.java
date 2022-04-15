// https://leetcode.com/problems/binary-tree-level-order-traversal/
package Trees;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new ArrayList<>();

        if (root == null) return wrapList;
        queue.add(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                list.add(node.val);
            }
            wrapList.add(list);
        }

        return wrapList;
    }
}
