// https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits
package All_Problems;

import java.util.Arrays;

public class MinimumSumOfFourDigitNumberAfterSplittingDigits {

    public static void main(String[] args) {
        int num = 2932;
        System.out.println(minimumSum(num));
    }

    public static int minimumSum(int num) {
        int[] list = new int[4];

        int i = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            list[i] = lastDigit;
            num /= 10;
            i++;
        }

        Arrays.sort(list);

        int num1 = (list[0] * 10) + list[3];
        int num2 = (list[1] * 10) + list[2];

        return num1 + num2;
    }
}
