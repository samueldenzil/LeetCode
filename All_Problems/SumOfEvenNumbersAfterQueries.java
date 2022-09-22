// https://leetcode.com/problems/sum-of-even-numbers-after-queries/
package All_Problems;

import java.util.Arrays;

public class SumOfEvenNumbersAfterQueries {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        System.out.println(Arrays.toString(sumEvenAfterQueries(nums, queries)));
    }

    public static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for (int it : nums) {
            if (it % 2 == 0) {
                sum += it;
            }
        }

        int[] ans = new int[nums.length];
        int i = 0;
        for (int[] query : queries) {
            int val = query[0];
            int index = query[1];

            if (nums[index] % 2 == 0) {
                sum -= nums[index];
            }
            nums[index] += val;
            if (nums[index] % 2 == 0) {
                sum += nums[index];
            }
            ans[i++] = sum;
        }

        return ans;
    }
}
