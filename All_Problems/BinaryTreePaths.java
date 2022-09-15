// https://leetcode.com/problems/binary-tree-paths/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths(root));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root, ans, new StringBuilder());
        return ans;
    }

    private static void helper(TreeNode root, List<String> ans, StringBuilder curr) {
        if (root.left == null && root.right == null) {
            int length = curr.length();
            curr.append(root.val);
            ans.add(curr.toString());
            curr.replace(length, curr.length(), "");
            return;
        }

        if (root.left != null) {
            int length = curr.length();
            curr.append(root.val);
            curr.append("->");
            helper(root.left, ans, curr);
            curr.replace(length, curr.length(), "");
        }
        if (root.right != null) {
            int length = curr.length();
            curr.append(root.val);
            curr.append("->");
            helper(root.right, ans, curr);
            curr.replace(length, curr.length(), "");
        }
    }
}
