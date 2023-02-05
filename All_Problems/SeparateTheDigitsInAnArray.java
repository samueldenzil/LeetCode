// https://leetcode.com/problems/separate-the-digits-in-an-array/
package All_Problems;

import java.util.Arrays;

public class SeparateTheDigitsInAnArray {

    public static void main(String[] args) {
        int[] nums = {13, 25, 83, 77};
        System.out.println(Arrays.toString(separateDigits(nums)));
    }

    public static int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }

        int[] ans = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            ans[i] = sb.charAt(i) - '0';
        }
        return ans;
    }
}
