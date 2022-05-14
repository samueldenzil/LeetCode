// https://leetcode.com/problems/same-tree/
package All_Problems;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case
        if (p == null || q == null) {
            return (p == q);
        }

        return isSameTree(p.left, q.left) && (p.val == q.val) && isSameTree(p.right, q.right);
    }
}
