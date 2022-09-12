// https://leetcode.com/problems/most-frequent-even-element/
package Arrays;

public class MostFrequentEvenElement {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 4, 4, 1};
        System.out.println(mostFrequentEven(nums));
    }

    public static int mostFrequentEven(int[] nums) {
        int[] frequency = new int[100001];
        boolean hasEven = false;
        for (int num : nums) {
            frequency[num]++;
            if (num % 2 == 0) {
                hasEven = true;
            }
        }

        if (!hasEven) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int ans = -1;
        for (int i = 0; i < frequency.length; i += 2) {
            if (frequency[i] > max) {
                max = frequency[i];
                ans = i;
            }
        }

        return ans;
    }
}
