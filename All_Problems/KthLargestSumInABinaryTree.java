// https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/
package All_Problems;

import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class KthLargestSumInABinaryTree {

    public static void main(String[] args) {
        String[] arr = {"5", "8", "9", "2", "1", "3", "7", "4", "6" };
        TreeNode root = generateTree(arr, 0);
        int k = 2;
        System.out.println(kthLargestLevelSum(root, k));
    }

    public static long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(); // min heap
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                sum += node.val;
            }
            pq.add(sum);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.size() == k ? pq.poll() : -1;
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
