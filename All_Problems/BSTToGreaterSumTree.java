// https://practice.geeksforgeeks.org/problems/bst-to-greater-sum-tree/1
package All_Problems;

public class BSTToGreaterSumTree {

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

    public static void transformTree(Node root) {
        //code here
        int[] sum = new int[1];
        helper(root, sum);
    }

    private static void helper(Node node, int[] sum) {
        if (node == null) {
            return;
        }

        helper(node.right, sum);
        int temp = node.data;
        node.data = sum[0];
        sum[0] += temp;
        helper(node.left, sum);
    }
}
