// https://practice.geeksforgeeks.org/problems/maximum-sum-leaf-to-root-path/1
package All_Problems;

public class MaximumSumLeafToRootPath {

    public static int maxPathSum(TreeNode root) {
        //code here
        if (root == null) {
            return 0;
        }

        int left = root.val + maxPathSum(root.left);
        int right = root.val + maxPathSum(root.right);

        return Math.max(left, right);
    }
}
