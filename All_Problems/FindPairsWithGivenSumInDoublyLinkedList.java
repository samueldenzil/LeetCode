// https://practice.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1
package All_Problems;

import java.util.ArrayList;

public class FindPairsWithGivenSumInDoublyLinkedList {

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Node start = head;
        Node end = head;
        while (end.next != null) {
            end = end.next;
        }
        while (start != null && end != null && start.data < end.data) {
            int sum = start.data + end.data;

            if (sum == target) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(start.data);
                temp.add(end.data);
                ans.add(temp);
                start = start.next;
                end = end.prev;
            } else if (sum > target) {
                end = end.prev;
            } else {
                start = start.next;
            }
        }

        return ans;
    }

    static class Node {
        int data;
        Node next, prev;

        Node(int x) {
            data = x;
            next = null;
            prev = null;
        }
    }
}
