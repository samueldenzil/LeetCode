// https://practice.geeksforgeeks.org/problems/largest-value-in-each-level/1
package All_Problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class LargestValueInEachLevel {

    public List<Integer> largestValues(TreeNode root) {
        //code here
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int max = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                max = Math.max(max, node.val);
            }
            ans.add(max);
        }

        return ans;
    }
}
