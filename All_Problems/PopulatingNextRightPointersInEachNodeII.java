// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
package All_Problems;

import java.util.Queue;
import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNodeII {

    static class NodeN {
        public int val;
        public NodeN left;
        public NodeN right;
        public NodeN next;

        public NodeN() {
        }

        public NodeN(int _val) {
            val = _val;
        }

        public NodeN(int _val, NodeN _left, NodeN _right, NodeN _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public NodeN connect(NodeN root) {
        Queue<NodeN> queue = new LinkedList<>();

        if (root == null) return root;

        NodeN nextRightNode = null;
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                NodeN node = queue.poll();
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }

                node.next = nextRightNode;
                nextRightNode = node;
            }

            nextRightNode = null;
        }

        return root;
    }
}
