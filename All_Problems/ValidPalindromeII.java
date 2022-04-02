// https://leetcode.com/problems/valid-palindrome-ii/
package All_Problems;

public class ValidPalindromeII {

    public static void main(String[] args) {
        String s = "aba";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while (i <= j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);

            if (c1 != c2) {
                // check if after deleting the j'th are we getting a palindrome
                boolean ans1 = checkAfterDelete(s, i, j - 1);

                if (ans1) {
                    // if we are getting a palindrome then return true
                    return ans1;
                } else {
                    // if we are not getting a palindrome after deleting the j'th element
                    // then try removing the i'th element and then return the result
                    return checkAfterDelete(s, i + 1, j);
                }

            }
            i++;
            j--;
        }

        return true;
    }

    public static boolean checkAfterDelete(String s, int i, int j) {
        while (i <= j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (c1 != c2) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
