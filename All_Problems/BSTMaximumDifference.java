// https://practice.geeksforgeeks.org/problems/e841e10213ddf839d51c2909f1808632a19ae0bf/1
package All_Problems;

public class BSTMaximumDifference {

    public static void main(String[] args) {
        String[] arr = {"25", "20", "35", "15", "22", "30", "45", null, null, null, null, null, "32"};
        int target = 20;
        TreeNode root = generateTree(arr, 0);
        System.out.println(maxDifferenceBST(root, target));
    }

    public static int maxDifferenceBST(TreeNode root, int target) {
        // Please code here
        int ans = searchTarget(root, target, 0);
        return ans != Integer.MAX_VALUE ? ans : -1;
    }

    private static int searchTarget(TreeNode root, int target, int sum) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (target == root.val) {
            int left = getSubTreeSum(root.left);
            int right = getSubTreeSum(root.right);
            int ans = 0;
            if (left == Integer.MAX_VALUE && right == Integer.MAX_VALUE) {
                ans = sum;
            } else {
                ans = sum - Math.min(left, right);
            }
            return ans;
        } else if (target < root.val) {
            return searchTarget(root.left, target, sum + root.val);
        } else {
            return searchTarget(root.right, target, sum + root.val);
        }
    }

    private static int getSubTreeSum(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int left = getSubTreeSum(root.left);
        int right = getSubTreeSum(root.right);

        return root.val + Math.min(left, right);
    }

    private static TreeNode generateTree(String[] arr, int i) {
        TreeNode root = null;
        if (i < arr.length && arr[i] != null) {
            root = new TreeNode(Integer.parseInt(arr[i]));
            root.left = generateTree(arr, i * 2 + 1);
            root.right = generateTree(arr, i * 2 + 2);
        }
        return root;
    }
}
