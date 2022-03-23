// https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
package All_Problems;

import java.util.Arrays;

public class SmallestStringWithAGivenNumericValue {

    public static void main(String[] args) {
//        int n = 3, k = 27;
        int n = 5, k = 73;
        System.out.println(getSmallestString(n, k));
    }

    public static String getSmallestString(int n, int k) {
        char[] ans = new char[n];
        Arrays.fill(ans, 'a');
        k -= n;

        while (k > 0) {
            ans[--n] += Math.min(25, k);
            k -= Math.min(25, k);
        }

        return String.valueOf(ans);
    }

    /*
      public String getSmallestString(int n, int k) {
        char[] letters = new char[27];
        for (int i = 1; i < letters.length; i++) {
            letters[i] = (char) ('a' + i - 1);
        }

        int currentSum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(letters[1]);
            currentSum += 1;
        }

        int i = sb.length() - 1;
        int temp = 26;
        while (currentSum < k) {
            if (currentSum - 1 + temp <= k) {
                sb.setCharAt(i, letters[temp]);
//                currentSum = currentSum - 1 + temp;
                currentSum += (temp - 1);
                temp = 26;
                i--;
            } else {
                temp--;
            }
        }
        return sb.toString();
    }*/
}
