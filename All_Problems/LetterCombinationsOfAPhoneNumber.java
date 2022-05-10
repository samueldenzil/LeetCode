// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        String[] set = new String[10];
        set[2] = "abc";
        set[3] = "def";
        set[4] = "ghi";
        set[5] = "jkl";
        set[6] = "mno";
        set[7] = "pqrs";
        set[8] = "tuv";
        set[9] = "wxyz";

        List<String> ans = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return ans;
        }

        helper(ans, digits, set, 0, "");

        return ans;
    }

    private static void helper(List<String> ans, String digit, String[] set, int index, String currString) {
        // Base case
        if (index == digit.length()) {
            ans.add(currString);
            return;
        }

        String possibleChars = set[digit.charAt(index) - '0'];

        for (char c : possibleChars.toCharArray()) {
            helper(ans, digit, set, index + 1, currString + c);
        }
    }
}
