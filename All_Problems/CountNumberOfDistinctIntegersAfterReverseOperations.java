// https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/
package All_Problems;

import java.util.Set;
import java.util.HashSet;

public class CountNumberOfDistinctIntegersAfterReverseOperations {

    public static void main(String[] args) {
        int[] nums = {1, 13, 10, 12, 31};
        System.out.println(countDistinctIntegers(nums));
    }

    public static int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int it : nums) {
            set.add(it);
            set.add(reverse(it));
        }

        return set.size();
    }

    private static int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            int unit = n % 10;
            rev *= 10;
            rev += unit;
            // rev = rev * 10 + unit;
            n /= 10;
        }
        return rev;
    }
}
