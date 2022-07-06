// https://practice.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1
package All_Problems;

public class CountBSTNodesThatLieInAGivenRange {

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
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(50);
        root.left.left = new Node(1);
        root.right.left = new Node(40);
        root.right.right = new Node(100);

        int l = 5;
        int h = 45;

        System.out.println(getCount(root, l, h));
    }

    public static int getCount(Node root, int l, int h) {
        if (root == null) {
            return 0;
        }

        int val = root.data;

        if (val >= l && val <= h) {
            int left = getCount(root.left, l, h);
            int right = getCount(root.right, l, h);

            return 1 + left + right;
        } else if (val < l) {
            return getCount(root.right, l, h);
        } else {
            return getCount(root.left, l, h);
        }
    }
}
