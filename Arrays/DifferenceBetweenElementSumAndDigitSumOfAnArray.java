// https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/
package Arrays;

public class DifferenceBetweenElementSumAndDigitSumOfAnArray {

    public static void main(String[] args) {
        int[] nums = {1, 15, 6, 3};
        System.out.println(differenceOfSum(nums));
    }

    public static int differenceOfSum(int[] nums) {
        int a = 0;
        int b = 0;
        for (int it : nums) {
            a += it;
            b += getDigitSum(it);
        }
        return Math.abs(a - b);
    }

    private static int getDigitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
