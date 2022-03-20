// https://leetcode.com/problems/divide-array-into-equal-pairs/
package Arrays;

import java.util.Arrays;

public class DivideArrayIntoEqualPairs {

	public static void main(String[] args) {
		int[] nums = {3, 2, 3, 2, 2, 2};
		System.out.println(divideArray(nums));
	}

	public static boolean divideArray(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i += 2) {
			if (i + 1 < nums.length && nums[i] != nums[i + 1]) {
				return false;
			}
		}

		return true;
	}
}