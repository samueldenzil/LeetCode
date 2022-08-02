// https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
package All_Problems;

import java.util.Set;
import java.util.HashSet;

public class MakeArrayZeroBySubtractingEqualAmounts {

    public static void main(String[] args) {
        int[] nums = {1, 5, 0, 3, 5};
        System.out.println(minimumOperations(nums));
    }

    public static int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num != 0) {
                set.add(num);
            }
        }

        return set.size();
    }
}
