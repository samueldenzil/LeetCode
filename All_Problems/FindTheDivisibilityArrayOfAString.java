// https://leetcode.com/problems/find-the-divisibility-array-of-a-string/
package All_Problems;

import java.util.Arrays;

public class FindTheDivisibilityArrayOfAString {

    public static void main(String[] args) {
        String word = "998244353";
        int m = 3;
        System.out.println(Arrays.toString(divisibilityArray(word, m)));
    }

    public static int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] ans = new int[n];
        long rem = 0;

        for (int i = 0; i < n; i++) {
            int d = word.charAt(i) - '0';
            rem = (10 * rem + d) % m;

            if (rem == 0) {
                ans[i] = 1;
            }
        }

        return ans;
    }
}
