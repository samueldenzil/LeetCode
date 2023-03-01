// https://leetcode.com/problems/find-duplicate-subtrees/
package Trees;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        getSubTreeString(root, ans, map);
        return ans;
    }

    private String getSubTreeString(TreeNode root, List<TreeNode> ans, Map<String, Integer> map) {
        if (root == null) {
            return "NULL";
        }

        String str = root.val + "," + getSubTreeString(root.left, ans, map) + "," + getSubTreeString(root.right, ans, map);

        if (map.getOrDefault(str, 0) == 1) {
            ans.add(root);
        }
        map.put(str, map.getOrDefault(str, 0) + 1);
        return str;
    }
}