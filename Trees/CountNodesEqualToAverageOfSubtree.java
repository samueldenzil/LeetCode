// https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
package Trees;

public class CountNodesEqualToAverageOfSubtree {

    public int averageOfSubtree(TreeNode root) {
        int[] count = new int[1];
        preorder(root, count);
        return count[0];
    }

    private int[] preorder(TreeNode node, int[] count) {
        // This function will return an array as {sumOfSubTree, noOfNodes} of SubTree
        // Base Case
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = preorder(node.left, count);
        int[] right = preorder(node.right, count);

        int sum = left[0] + right[0] + node.val;
        int noOfNodes = left[1] + right[1] + 1;

        if ((sum / noOfNodes) == node.val) count[0]++;

        return new int[]{sum, noOfNodes};
    }
}
