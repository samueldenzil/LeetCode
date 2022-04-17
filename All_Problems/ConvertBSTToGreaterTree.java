// https://leetcode.com/problems/convert-bst-to-greater-tree/
package All_Problems;

public class ConvertBSTToGreaterTree {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;

        TreeNode node1 = convertBST(root.right);
        root.val += sum;
        sum = root.val;
        TreeNode node2 = convertBST(root.left);

        return root;
    }
}
