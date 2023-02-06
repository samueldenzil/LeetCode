// https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/
package All_Problems;

import java.util.Set;
import java.util.HashSet;

public class MaximumNumberOfIntegersToChooseFromARangeI {

    public static void main(String[] args) {
        int[] banned = {1, 6, 5};
        int n = 5, maxSum = 6;
        System.out.println(maxCount(banned, n, maxSum));
    }

    public static int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for (int ban : banned) {
            if (ban <= n) {
                set.add(ban);
            }
        }

        int sum = 0;
        int i = 1;
        int count = 0;
        while (i <= n && sum <= maxSum) {
            if (set.contains(i)) {
                i++;
                continue;
            }

            sum += i;
            i++;
            count++;
        }

        return sum <= maxSum ? count : count - 1;
    }
}
