// https://leetcode.com/problems/sort-the-jumbled-numbers/
package Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class SortTheJumbledNumbers {

    public static void main(String[] args) {
        int[] mapping = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
        int[] nums = {991, 338, 38};
        System.out.println(Arrays.toString(sortJumbled(mapping, nums)));
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        // the main reason I was not able to solve this question during the Biweekly contest was
        // I was not familiar with java syntax

        List<int[]> list = new ArrayList<>();

        for (int num : nums) {
            int newNum = convertNum(num, mapping);
            list.add(new int[] {newNum, num});
        }

        list.sort((a, b) -> a[0] - b[0]);

        int[] ans = new int[nums.length];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i)[1];
        }

        return ans;
    }

    public static int convertNum(int num, int[] mapping) {
        int n = 0;
        String s = Integer.toString(num);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            n = n * 10 + (mapping[c - '0']);
        }
        return n;
    }
}
