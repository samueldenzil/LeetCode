// https://practice.geeksforgeeks.org/problems/4ead9c3991a3822f578309e2232bc5415ac35cb9/1
package All_Problems;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class MaximumWinningScore {

    public static Long findMaxScore(Node root) {
        //code here
        if (root == null) return (long) 1;

        long first = root.data * findMaxScore(root.left);
        long second = root.data * findMaxScore(root.right);

        return Math.max(first, second);
    }
}