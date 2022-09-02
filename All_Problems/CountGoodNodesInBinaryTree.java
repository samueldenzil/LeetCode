// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
package All_Problems;

public class CountGoodNodesInBinaryTree {

    public int goodNodes(TreeNode root) {
        return helper(root, root.val);
    }

    private int helper(TreeNode root, int currMax) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val >= currMax) {
            count++;
            currMax = root.val;
        }
        count += helper(root.left, currMax);
        count += helper(root.right, currMax);
        return count;
    }
}
