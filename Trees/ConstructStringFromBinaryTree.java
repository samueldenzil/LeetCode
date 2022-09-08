// https://leetcode.com/problems/construct-string-from-binary-tree/
package Trees;

public class ConstructStringFromBinaryTree {

    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        sb.append(root.val);
        if (root.left != null) {
            sb.append('(');
            preorder(root.left, sb);
            sb.append(')');
        }
        if (root.right != null) {
            if (root.left == null) {
                sb.append("()");
            }
            sb.append('(');
            preorder(root.right, sb);
            sb.append(')');
        }
    }
}
