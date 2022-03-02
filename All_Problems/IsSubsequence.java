// https://leetcode.com/problems/is-subsequence/

package All_Problems;

public class IsSubsequence {

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    // Using Two Pointer Approach
    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        // if i == s.length() it means that there is a subsequence of String 's' in String 't'
        return (i == s.length());
    }
}
