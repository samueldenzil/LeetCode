// https://leetcode.com/problems/path-sum-ii/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // edge case
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        helper(root, targetSum, ans, new ArrayList<>());
        return ans;
    }

    private void helper(TreeNode root, int target, List<List<Integer>> ans, List<Integer> curr) {
        if (root == null) {
            return;
        }

        // if this is the root node
        if (root.left == null && root.right == null) {
            if (root.val - target == 0) {
                curr.add(root.val);
                ans.add(new ArrayList<>(curr));
                curr.remove(curr.size() - 1);
            }
            return;
        }

        // left subtree
        curr.add(root.val);
        helper(root.left, target - root.val, ans, curr);
        curr.remove(curr.size() - 1);

        // right subtree
        curr.add(root.val);
        helper(root.right, target - root.val, ans, curr);
        curr.remove(curr.size() - 1);
    }
}
