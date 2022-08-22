// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
package All_Problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class AmountOfTimeForBinaryTreeToBeInfected {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Pair {
        int node;
        int t;

        Pair(int node, int t) {
            this.node = node;
            this.t = t;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);

        int start = 3;
        System.out.println(amountOfTime(root, start));
    }

    public static int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        generateAdjList(root, adj);

        Queue<Pair> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(new Pair(start, 0));
        visited.add(start);

        int time = 0;
        while (!queue.isEmpty()) {
            int node = queue.peek().node;
            int t = queue.peek().t;
            queue.poll();
            time = t;
            if (!adj.containsKey(node)) {
                break;
            }
            for (int it : adj.get(node)) {
                if (!visited.contains(it)) {
                    queue.add(new Pair(it, t + 1));
                    visited.add(it);
                }
            }
        }

        return time;
    }

    private static void generateAdjList(TreeNode root, Map<Integer, List<Integer>> adj) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    list = adj.getOrDefault(node.val, new ArrayList<>());
                    list.add(node.left.val);
                    adj.put(node.val, list);

                    list = adj.getOrDefault(node.left.val, new ArrayList<>());
                    list.add(node.val);
                    adj.put(node.left.val, list);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    list = adj.getOrDefault(node.val, new ArrayList<>());
                    list.add(node.right.val);
                    adj.put(node.val, list);

                    list = adj.getOrDefault(node.right.val, new ArrayList<>());
                    list.add(node.val);
                    adj.put(node.right.val, list);
                    queue.add(node.right);
                }
            }
        }
    }
}
