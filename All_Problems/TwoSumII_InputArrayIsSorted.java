// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
package All_Problems;

import java.util.Arrays;

public class TwoSumII_InputArrayIsSorted {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];

        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int curr = numbers[start] + numbers[end];

            if (curr == target) {
                ans[0] = start + 1;
                ans[1] = end + 1;
                break;
            } else if (curr > target) {
                end--;
            } else {
                start++;
            }
        }

        return ans;
    }
}
