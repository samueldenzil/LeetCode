// https://leetcode.com/problems/product-of-array-except-self/
package Arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int[] prefix = new int[n];
        prefix[0] = nums[0];

        int[] postfix = new int[n];
        postfix[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i];
        }

        for (int i = 0; i < n; i++) {
            if (i - 1 < 0) {
                ans[i] = postfix[i + 1];
            } else if (i + 1 >= n) {
                ans[i] = prefix[i - 1];
            } else {
                ans[i] = prefix[i - 1] * postfix[i + 1];
            }
        }

        return ans;
    }
}
