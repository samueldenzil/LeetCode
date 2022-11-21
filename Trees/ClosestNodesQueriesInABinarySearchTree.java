// https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/
package Trees;

import java.util.List;
import java.util.ArrayList;

public class ClosestNodesQueriesInABinarySearchTree {

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        for (int q : queries) {
            int min = findMin(list, q);
            int max = findMax(list, q);
            List<Integer> curr = new ArrayList<>();
            curr.add(min);
            curr.add(max);
            ans.add(curr);
        }

        return ans;
    }

    private int findMin(List<Integer> list, int t) {
        int start = 0;
        int end = list.size() - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) == t) {
                ans = t;
                break;
            } else if (list.get(mid) < t) {
                ans = list.get(mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private int findMax(List<Integer> list, int t) {
        int start = 0;
        int end = list.size() - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) == t) {
                ans = t;
                break;
            } else if (list.get(mid) > t) {
                ans = list.get(mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
