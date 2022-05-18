// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
package Trees;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        inorder(original, cloned);

        return ans;
    }

    private TreeNode target;
    private TreeNode ans;

    private void inorder(TreeNode original, TreeNode cloned) {
        if (original == null) return;

        inorder(original.left, cloned.left);
        if (original == target) {
            ans = cloned;
            return;
        }
        inorder(original.right, cloned.right);
    }
}
