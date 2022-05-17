// https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1#
package All_Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseLevelOrderTraversal {

    private static class Node {
        private int data;
        private Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(9);
        root.right = new Node(4);
        root.left.right = new Node(9);
        root.right.left = new Node(6);
        root.right.right = new Node(10);
        root.left.right.right = new Node(10);
        root.right.left.left = new Node(6);

        System.out.println(reverseLevelOrder(root));
    }

    public static ArrayList<Integer> reverseLevelOrder(Node node) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                level.add(node.data);
            }

            ans.addAll(0, level);
        }

        return ans;
    }
}
