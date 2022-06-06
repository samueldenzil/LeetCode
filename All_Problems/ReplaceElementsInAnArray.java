// https://leetcode.com/problems/replace-elements-in-an-array/
package All_Problems;

import java.util.Arrays;
import java.util.HashMap;

public class ReplaceElementsInAnArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6};
        int[][] operations = {{1, 3}, {4, 7}, {6, 1}};
        System.out.println(Arrays.toString(arrayChange(nums, operations)));
    }

    public static int[] arrayChange(int[] nums, int[][] operations) {
        int n = nums.length;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hashMap.put(nums[i], i);
        }

        for (int[] task : operations) {
            if (!hashMap.containsKey(task[0])) {
                continue;
            }
            int index = hashMap.get(task[0]);
            nums[index] = task[1];
            hashMap.put(nums[index], index);
        }

        return nums;
    }
}
