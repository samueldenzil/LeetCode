// https://leetcode.com/problems/minimum-distance-between-bst-nodes/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class MinimumDistanceBetweenBSTNodes {

    public static void main(String[] args) {
        String[] arr = {"4", "2", "6", "1", "3"};
        TreeNode root = generateTree(arr, 0);
        System.out.println(minDiffInBST(root));
    }

    public static int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    private static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private static TreeNode generateTree(String[] arr, int i) {
        TreeNode root = null;
        if (i < arr.length && arr[i] != null) {
            root = new TreeNode(Integer.parseInt(arr[i]));
            root.left = generateTree(arr, i * 2 + 1);
            root.right = generateTree(arr, i * 2 + 2);
        }
        return root;
    }
}
