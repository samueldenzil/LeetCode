// https://practice.geeksforgeeks.org/problems/print-all-nodes-that-dont-have-sibling/1
package Trees;

import java.util.ArrayList;

public class PrintAllNodesThatDontHaveSibling {

    public ArrayList<Integer> noSibling(TreeNode node) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        helper(node, ans);
        ans.sort((a, b) -> (a - b));
        if (ans.size() == 0) {
            ans.add(-1);
        }
        return ans;
    }

    private void helper(TreeNode node, ArrayList<Integer> ans) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        if (node.left == null) {
            ans.add(node.right.val);
        }
        if (node.right == null) {
            ans.add(node.left.val);
        }
        helper(node.left, ans);
        helper(node.right, ans);
    }
}
