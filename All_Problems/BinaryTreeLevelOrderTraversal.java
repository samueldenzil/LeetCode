// https://leetcode.com/problems/binary-tree-level-order-traversal/
package All_Problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {

    // BFS Traversal
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

    
    // DFS Traversal
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }

    private void helper(TreeNode node, int height, List<List<Integer>> ans) {
        if (node == null) {
            return;
        }
        if (height == ans.size()) { // visiting the level for the first time
            ans.add(new ArrayList<>());
        }

        ans.get(height).add(node.val);
        helper(node.left, height + 1, ans);
        helper(node.right, height + 1, ans);
    }
}
