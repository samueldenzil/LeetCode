// https://leetcode.com/problems/3sum-closest/
package All_Problems;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int first = nums[i];
            int start = i + 1;
            int end = n - 1;

            while (start < end) {
                int sum = first + nums[start] + nums[end];
                if (sum == target) {
                    return target;
                } else if (Math.abs(target - sum) < diff) {
                    diff = Math.abs(target - sum);
                    ans = sum;
                }

                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return ans;
    }
}
