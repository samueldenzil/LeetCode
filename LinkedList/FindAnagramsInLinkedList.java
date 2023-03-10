// https://practice.geeksforgeeks.org/problems/de6f6a196aecdfb3e4939ba7729809a5a4bdfe90/1
package LinkedList;

import java.util.List;
import java.util.ArrayList;

public class FindAnagramsInLinkedList {

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'a', 'd', 'b', 'c', 'a'};
        Node head = generateLinkedList(arr);
        String s = "bac";
        List<Node> ans = findAnagrams(head, s);
        for (Node temp : ans) {
            printList(temp);
        }
    }

    public static List<Node> findAnagrams(Node head, String s) {
        // code here
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;
        }

        List<Node> ans = new ArrayList<>();

        while (head != null) {
            if (isAnagram(head, n, freq)) {
                ans.add(head);
            } else {
                head = head.next;
                continue;
            }

            int steps = 0;
            while (head != null && steps < n - 1) {
                head = head.next;
                steps++;
            }
            if (head != null) {
                Node end = head;
                head = head.next;
                end.next = null;
            }
        }

        return ans;
    }

    private static boolean isAnagram(Node head, int n, int[] freq) {
        int[] temp = new int[26];
        while (head != null && n > 0) {
            temp[head.data - 'a']++;
            head = head.next;
            n--;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] != temp[i]) {
                return false;
            }
        }
        return true;
    }

    private static Node generateLinkedList(char[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    private static class Node {
        char data;
        Node next;

        Node(char x) {
            data = x;
            next = null;
        }
    }
}
