// https://leetcode.com/problems/average-value-of-even-numbers-that-are-divisible-by-three
package Arrays;

public class AverageValueOfEvenNumbersThatAreDivisibleByThree {

    public static void main(String[] args) {
        int[] nums = {4, 4, 9, 10};
        System.out.println(averageValue(nums));
    }

    public static int averageValue(int[] nums) {
        int avg = 0;
        int n = 0;

        for (int it : nums) {
            if (it % 2 == 0 && it % 3 == 0) {
                avg += it;
                n++;
            }
        }

        return n != 0 ? avg / n : 0;
    }
}
