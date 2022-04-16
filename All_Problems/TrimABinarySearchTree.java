// https://leetcode.com/problems/trim-a-binary-search-tree/
package All_Problems;

public class TrimABinarySearchTree {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        // Base case
        if (root == null)
            return null;

        if (low <= root.val && root.val <= high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        } else if (root.val < low) {
            // then all the nodes to the left of the root node will be smaller than low, hence go to right
            return trimBST(root.right, low, high);
        } else {
            // then all the nodes to the right of the root node will be greater than high, hence go to left
            return trimBST(root.left, low, high);
        }

        return root;
    }
}
