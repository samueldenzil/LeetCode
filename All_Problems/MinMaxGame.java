// https://leetcode.com/problems/min-max-game/
package All_Problems;

public class MinMaxGame {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 4, 8, 2, 2};
        System.out.println(minMaxGame(nums));
    }

    public static int minMaxGame(int[] nums) {
        int size = nums.length;

        while (size > 1) {
            for (int i = 0; i < size / 2; i++) {
                if (i % 2 == 0) {
                    nums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    nums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            size /= 2;
        }

        return nums[0];
    }
}
