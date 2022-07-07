// https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1
package Trees;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class DiagonalTraversalOfBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.right.right.left = new Node(13);

        System.out.println(diagonal(root));
    }

    public static ArrayList<Integer> diagonal(Node root) {
        //add your code here.
        Map<Integer, List<Integer>> map = new HashMap<>();
        preorder(root, 0, map);

        ArrayList<Integer> ans = new ArrayList<>();
        for (int level : map.keySet()) {
            List<Integer> list = map.get(level);
            ans.addAll(list);
        }

        return ans;
    }

    private static void preorder(Node node, int level, Map<Integer, List<Integer>> map) {
        if (node == null) {
            return;
        }

        List<Integer> currList = map.get(level);
        if (currList == null) {
            currList = new ArrayList<>();
        }
        currList.add(node.data);
        map.put(level, currList);


        // if we go to the left child the level will be increased by 1
        preorder(node.left, level + 1, map);

        // if we go to the right child the level will remain the same
        preorder(node.right, level, map);
    }
}
