// https://leetcode.com/problems/number-of-distinct-averages/
package Arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class NumberOfDistinctAverages {

    public static void main(String[] args) {
        int[] nums = {4, 1, 4, 0, 3, 5};
        System.out.println(distinctAverages(nums));
    }

    public static int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Double> set = new HashSet<>();
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            set.add((nums[i] + nums[j]) / 2.0);
            i++;
            j--;
        }
        return set.size();
    }
}
