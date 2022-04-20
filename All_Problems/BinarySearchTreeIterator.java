// https://leetcode.com/problems/binary-search-tree-iterator/
package All_Problems;

import java.util.Stack;

public class BinarySearchTreeIterator {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BinarySearchTreeIterator bSTIterator = new BinarySearchTreeIterator(root);
        System.out.println(bSTIterator.next());    // return 3
        System.out.println(bSTIterator.next());    // return 7
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 9
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 15
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 20
        System.out.println(bSTIterator.hasNext()); // return False
    }

    Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        addAllLeft(root);
    }

    public void addAllLeft(TreeNode root) {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode root = stack.pop();
        addAllLeft(root.right);
        return root.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
