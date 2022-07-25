// https://leetcode.com/problems/design-hashset/
package LinkedList;

public class MyHashSetUsingLinkedList {

    int size = 97;  // taking a random prime number
    ListNode[] arr;

    public MyHashSetUsingLinkedList() {
        arr = new ListNode[size];
    }

    public void add(int key) {
        if (contains(key)) {
            return;
        }

        int index = hashFunction(key);
        ListNode head = arr[index];

        if (head == null) { // when we are dealing with first element
            arr[index] = new ListNode(key);
            return;
        }

        while (head.next != null) {
            head = head.next;
        }
        head.next = new ListNode(key);
    }

    public void remove(int key) {
        if (!contains(key)) {
            return;
        }

        int index = hashFunction(key);
        ListNode head = arr[index];

        if (head.val == key) {
            arr[index] = head.next;
            return;
        }

        while (head.next != null) {
            if (head.next.val == key) {
                break;
            }
            head = head.next;
        }

        head.next = head.next.next;
    }

    public boolean contains(int key) {
        int index = hashFunction(key);
        ListNode head = arr[index];

        while (head != null) {
            if (head.val == key) {
                return true;
            }
            head = head.next;
        }

        return false;
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public static void main(String[] args) {
        MyHashSetUsingLinkedList myHashSet = new MyHashSetUsingLinkedList();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // return True
        System.out.println(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // return False, (already removed)
    }
}
