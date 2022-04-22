// https://leetcode.com/problems/design-hashset/
package Design;

class MyHashSet {

    boolean[] set = null;

    public MyHashSet() {
        set = new boolean[1000001];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);                            // set = [1]
        myHashSet.add(2);                            // set = [1, 2]
        System.out.println(myHashSet.contains(1));    // return True
        System.out.println(myHashSet.contains(3));    // return False, (not found)
        myHashSet.add(2);                            // set = [1, 2]
        System.out.println(myHashSet.contains(2));    // return True
        myHashSet.remove(2);                        // set = [1]
        System.out.println(myHashSet.contains(2));    // return False, (already removed)
    }
}