// https://leetcode.com/problems/find-closest-number-to-zero/
package All_Problems;

import java.util.Arrays;

public class FindClosestNumberToZero {

    public static void main(String[] args) {
        int[] nums = {-4, -2, 1, 4, 8};
        System.out.println(findClosestNumber(nums));
    }

    public static int findClosestNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int difference = Integer.MAX_VALUE;

        for (int num : nums) {
            if (difference >= Math.abs(num)) {
                difference = Math.abs(num);
                ans = num;
            } else {
                break;
            }
        }

        return ans;
    }
}
