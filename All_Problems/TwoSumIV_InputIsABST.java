// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
package All_Problems;

import java.util.Set;
import java.util.HashSet;

public class TwoSumIV_InputIsABST {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }

    private boolean helper(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }

        if (set.contains(root.val)) {
            return true;
        }
        set.add(k - root.val);

        boolean left = helper(root.left, k, set);
        boolean right = false;
        if (!left) {
            right = helper(root.right, k, set);
        }

        return left || right;
    }
}
