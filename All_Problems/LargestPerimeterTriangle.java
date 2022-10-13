// https://leetcode.com/problems/largest-perimeter-triangle/
package All_Problems;

import java.util.Arrays;

public class LargestPerimeterTriangle {

    public static void main(String[] args) {
        int[] nums = {2, 1, 2};
        System.out.println(largestPerimeter(nums));
    }

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        // For a >= b >= c, a,b,c can form a triangle if a < b + c
        for (int i = nums.length - 1; i >= 2; i--) {
            int a = nums[i];
            int b = nums[i - 1];
            int c = nums[i - 2];

            if (a < b + c) {
                return a + b + c;
            }
        }

        return 0;
    }
}
