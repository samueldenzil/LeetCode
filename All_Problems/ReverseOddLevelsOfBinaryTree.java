// https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/
package All_Problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class ReverseOddLevelsOfBinaryTree {

    public static TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean reverse = false;

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                list.add(node);
            }
            if (reverse) {
                reverseLevel(list);
            }
            reverse = !reverse;
        }

        return root;
    }

    private static void reverseLevel(List<TreeNode> list) {
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int temp = list.get(start).val;
            list.get(start).val = list.get(end).val;
            list.get(end).val = temp;
            start++;
            end--;
        }
    }
}
