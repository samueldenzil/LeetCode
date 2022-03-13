// https://leetcode.com/problems/copy-list-with-random-pointer/
package LinkedList;

import java.util.Map;
import java.util.HashMap;

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;

        // creating a copy of each node
        while (temp != null) {
            // (original node, copied node)
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        // connecting each node
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }
}
