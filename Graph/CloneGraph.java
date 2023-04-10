// https://leetcode.com/problems/clone-graph/
package Graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();  // original node address, clone node address
        Queue<Node> queue = new LinkedList<>();
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        queue.offer(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node originalNode = queue.poll();
                for (Node it : originalNode.neighbors) {
                    if (!map.containsKey(it)) {
                        Node newIt = new Node(it.val);
                        queue.offer(it);
                        map.put(it, newIt);
                    }

                    Node cloneNode = map.get(originalNode);
                    cloneNode.neighbors.add(map.get(it));
                }
            }
        }

        return map.get(node);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
