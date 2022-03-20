// https://leetcode.com/problems/count-hills-and-valleys-in-an-array/
package Arrays;

public class CountHillsAndValleysInAnArray {

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 1, 6, 5};
        System.out.println(countHillValley(nums));
    }

    public static int countHillValley(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            int index = i - 1;
            while (index > 0 && nums[i] == nums[index]) {
                index--;
            }
            int leftElement = nums[index];

            index = i + 1;
            while (index < nums.length - 1 && nums[i] == nums[index]) {
                index++;
            }
            int rightElement = nums[index];

            if (leftElement < nums[i] && nums[i] > rightElement) {
                // hill encountered
                count++;
            } else if (leftElement > nums[i] && nums[i] < rightElement) {
                // vally encountered
                count++;
            }
            // if we encounter the same vally or hill
            i = index - 1;
        }

        return count;
    }
}