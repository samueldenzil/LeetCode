// https://leetcode.com/problems/find-the-distinct-difference-array/
package Arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class FindTheDistinctDifferenceArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] ans = distinctDifferenceArray(nums);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            prefix[i] = set.size();
        }

        set.clear();
        int[] suffix = new int[n];
        for (int i = n - 1; i > 0; i--) {
            set.add(nums[i]);
            suffix[i - 1] = set.size();
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = prefix[i] - suffix[i];
        }

        return ans;
    }
}
