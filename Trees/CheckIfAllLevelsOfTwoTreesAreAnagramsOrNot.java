// https://practice.geeksforgeeks.org/problems/check-if-all-levels-of-two-trees-are-anagrams-or-not/1
package Trees;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class CheckIfAllLevelsOfTwoTreesAreAnagramsOrNot {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(3);
        node1.right = new TreeNode(2);
        node1.right.left = new TreeNode(5);
        node1.right.right = new TreeNode(4);


        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(2);
        node2.right = new TreeNode(3);
        node2.right.left = new TreeNode(4);
        node2.right.right = new TreeNode(5);

        System.out.println(areAnagrams(node1, node2));
    }

    public static boolean areAnagrams(TreeNode node1, TreeNode node2) {
        // code here
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        Set<Integer> set1 = new HashSet<>();

        queue1.add(node1);
        queue2.add(node2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                node1 = queue1.poll();
                if (node1 == null) {
                    continue;
                }
                set1.add(node1.val);
                if (node1.left != null) {
                    queue1.add(node1.left);
                }
                if (node1.right != null) {
                    queue1.add(node1.right);
                }
            }
            size = queue2.size();
            for (int i = 0; i < size; i++) {
                node2 = queue2.poll();
                if (node2 == null) {
                    continue;
                }
                if (!set1.contains(node2.val)) {
                    return false;
                }
                if (node2.left != null) {
                    queue2.add(node2.left);
                }
                if (node2.right != null) {
                    queue2.add(node2.right);
                }
            }
        }

        return true;
    }
}
