// https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1
package All_Problems;

import java.util.Set;
import java.util.LinkedHashSet;

public class RemoveDuplicatesFromAnUnsortedLinkedList {

    public Node removeDuplicates(Node head) {
        // Your code here
        Set<Integer> set = new LinkedHashSet<>();
        Node temp = head;

        while (temp != null) {
            set.add(temp.val);
            temp = temp.next;
        }

        temp = head;
        int count = 0;
        for (int data : set) {
            temp.val = data;
            count++;
            if (count == set.size()) {
                temp.next = null;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }
}
