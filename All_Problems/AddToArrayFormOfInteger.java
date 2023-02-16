// https://leetcode.com/problems/add-to-array-form-of-integer/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class AddToArrayFormOfInteger {

    public static void main(String[] args) {
        int[] num = {1, 2, 0, 0};
        int k = 34;
        System.out.println(addToArrayForm(num, k));
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int i = num.length - 1;
        int carry = 0;

        while (i >= 0 || k != 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num[i];
                i--;
            }
            if (k != 0) {
                sum += k % 10;
                k /= 10;
            }
            ans.add(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            ans.add(carry);
        }

        reverse(ans);
        return ans;
    }

    private static void reverse(List<Integer> ans) {
        int i = 0;
        int j = ans.size() - 1;
        while (i < j) {
            int temp = ans.get(i);
            ans.set(i, ans.get(j));
            ans.set(j, temp);
            i++;
            j--;
        }
    }
}
