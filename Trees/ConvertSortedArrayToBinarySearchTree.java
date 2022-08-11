// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
package Trees;

public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return constructTreeFromArray(0, nums.length - 1, nums);
    }

    private TreeNode constructTreeFromArray(int start, int end, int[] nums) {
        // base case
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTreeFromArray(start, mid - 1, nums);
        root.right = constructTreeFromArray(mid + 1, end, nums);
        return root;
    }
}
