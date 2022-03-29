// https://leetcode.com/problems/find-palindrome-with-fixed-length/
package All_Problems;

import java.util.Arrays;

public class FindPalindromeWithFixedLength {

    public static void main(String[] args) {
        int[] queries = {1, 2, 3, 4, 5, 90};
        int intLength = 3;
        System.out.println(Arrays.toString(kthPalindrome(queries, intLength)));
    }

    public static long[] kthPalindrome(int[] queries, int intLength) {
        /*
        This problem was just observation

        We can see a pattern that
        1001, 1111, 1221, 1331, 1441, 1551, etc.

        Here we can see the first half of all the numbers they are 1 increment of their previous number starting with
        10, 11, 12, 13,.. and so on,

        So we can solve this problem by just finding the first element, but how?
        -> we can see that the first half of the first element is a power of 10, we can do something to get that value
        -> if intLength % 2 == 1, then calculate 10 ^ (intLength / 2 - 1);
        -> else calculate 10 ^ (intLength / 2);

        And for the second half we just have to reverse the first have and append it to the first half
        but if intLength % 2 == 0 then, we can directly append the revered number
        if intLength % 2 != 0 then, we have to skip the 0th index of the reversed number and append the remaining part
        */

        long[] ans = new long[queries.length];

        int power = intLength % 2 == 0 ? intLength / 2 - 1 : intLength / 2;
        int start = (int) Math.pow(10, power);

        int j = 0;
        for (int i : queries) {
            StringBuilder sb = new StringBuilder();
            sb.append(start + i - 1);
            StringBuilder secondHalf = new StringBuilder(sb);
            secondHalf.reverse();
            if (intLength % 2 == 0) {
                sb.append(secondHalf);
            } else {
                sb.append(secondHalf.substring(1, secondHalf.length()));
            }
            ans[j] = sb.length() == intLength ? Long.parseLong(sb.toString()) : -1;
            j++;
        }

        return ans;
    }
}
