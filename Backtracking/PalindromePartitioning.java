// https://leetcode.com/problems/palindrome-partitioning/
package Backtracking;

import java.util.List;
import java.util.ArrayList;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(0, s, ans, new ArrayList<>());
        return ans;
    }

    private static void helper(int idx, String s, List<List<String>> ans, List<String> curr) {
        int n = s.length();
        if (idx == n) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < n; i++) {
            if (isPalindrome(s, idx, i)) {
                curr.add(s.substring(idx, i + 1));
                helper(i + 1, s, ans, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
